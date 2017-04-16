/**
 * @File PackageSelect.java
 * @author zeng
 * @Date 2017-04-16
 * @Time 11:42
 */

package com.yunjuanyunshu.ui;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PackageSelect extends JFrame implements TreeSelectionListener {

    JTree jTree;
    JButton jButton;
    GridMain parentJFrame;
    String projectSrcRootPath;
    public PackageSelect(GridMain parentJFrame,String projectSrcRootPath){
        this.parentJFrame = parentJFrame;
        this.projectSrcRootPath = projectSrcRootPath;
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        jTree =  new JTree();
        jButton = new JButton("OK");
        //树的数据模型
        DefaultTreeModel model = new DefaultTreeModel(getSrcRootNode(projectSrcRootPath));

        //设置数据模型
        jTree.setModel(model);

        //添加事件
        jTree.addTreeSelectionListener(this);

        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(e);
            }
        });

        //滚动面板
        JScrollPane jScrollPane = new JScrollPane(jTree,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //添加树到滚动面板
        jScrollPane.getViewport().add(jTree);

        //添加OK按钮到滚动面板
        add(jButton,BorderLayout.SOUTH);
//        JPanel jPanel = new JPanel();
//        jPanel.add(jButton);
//        jPanel.setVisible(true);
        //添加滚动面板到窗口中
        //this.getContentPane().add(jScrollPane);
        this.add(jScrollPane,BorderLayout.CENTER);
        //this.add(jPanel);
        this.setTitle("选择包");
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(true);
        jScrollPane.setPreferredSize(new Dimension(300,600));
        jScrollPane.revalidate();
        setPreferredSize(new Dimension(300,600));
        setSize(300,600);
        revalidate();
        setVisible(true);
    }


    /**
     * 根据路径生成Tree中的根节点
     * @param rootPath 源码路径
     * @return Tree中的根节点
     */
    private DefaultMutableTreeNode getSrcRootNode(String rootPath){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("包目录");
        getChildFiles(rootPath,root);
        return  root;
    }

    /**
     * 根据选择的包返回包名
     * @param node 当前选中节点
     * @return 选择的包名
     */
    private String getPackageName(DefaultMutableTreeNode node){
        if(node == null){
            return "";
        }
        String tmpPackageName = "";
        TreeNode[] parentNodes =  node.getPath();
        for(TreeNode tmp :  parentNodes){
            String tmpStr = (String) ((DefaultMutableTreeNode) tmp).getUserObject();
            if(!tmpStr.equals("包目录")){
                tmpPackageName = tmpPackageName +"." + tmpStr;
            }
        }
        return  (tmpPackageName !=null && tmpPackageName.length() > 1) ? tmpPackageName.substring(1) : "";
    }

    /**
     * 获取子包信息
     * @param path 子包路径
     * @param parentNode 子包节点
     */
    private void getChildFiles(String path,DefaultMutableTreeNode parentNode){
        File tmpFile = new File(path);
        if(tmpFile.exists() && tmpFile.isDirectory()){
            File[] childFiles = tmpFile.listFiles();
            for (File tmp: childFiles ) {
                if(tmp.isDirectory()){
                    DefaultMutableTreeNode tmpNode = new DefaultMutableTreeNode(tmp.getName());
                    parentNode.add(tmpNode);
                    getChildFiles(tmp.getAbsoluteFile().getAbsolutePath(),tmpNode);
                }
            }
        }
    }

    @Override
    /**
     * 树选中节点变化事件
     * @param e 选择事件对象
     */
    public void valueChanged(TreeSelectionEvent e) {

    }

    /**
     * OK按钮点击事件
     * @param anActionEvent 按钮点击事件对象
     */
    private void onOK(ActionEvent anActionEvent) {
        //获取选择的节点
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
        parentJFrame.setPackageText(getPackageName(node));
        this.setVisible(false);
        this.dispose();
    }
}
