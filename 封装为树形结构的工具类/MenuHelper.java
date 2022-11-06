package com.fosss.system.utils;

import com.fosss.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * 将菜单封装成树形结构的工具类
 */
public class MenuHelper {

    public static List<SysMenu> buildTree(List<SysMenu> menusList) {
        //创建集合封装最后的树形结构
        List<SysMenu> menusTreeList = new ArrayList<>();

        //1.对所有的一级菜单（parentId==0）进行处理
        for (SysMenu sysMenu : menusList) {
            if (Integer.parseInt(sysMenu.getParentId()) == 0) {
                menusTreeList.add(getChildren(sysMenu, menusList));
            }
        }
        return menusTreeList;
    }

    /**
     * 递归封装所有菜单的子菜单
     */
    private static SysMenu getChildren(SysMenu sysMenu, List<SysMenu> menusList) {
        //对当前菜单的子菜单进行初始化（当前菜单的子菜单是集合类型，需要初始化）
        sysMenu.setChildren(new ArrayList<>());
        for (SysMenu menu : menusList) {
            //找到当前菜单的子菜单（当前菜单的id==子菜单的parentId）
            if (menu.getParentId().equals(sysMenu.getId())) {
                sysMenu.getChildren().add(getChildren(menu, menusList));
            }
        }
        return sysMenu;
    }
}





















