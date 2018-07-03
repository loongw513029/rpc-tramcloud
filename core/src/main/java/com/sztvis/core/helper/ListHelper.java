package com.sztvis.core.helper;

import com.sztvis.common.ComboTreeModel;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/19 上午11:13
 */
public class ListHelper {
    public static List addFirstEleComboTree(List list, String prompt){
        ComboTreeModel comboTreeModel = new ComboTreeModel();
        comboTreeModel.setId(0);
        comboTreeModel.setText(prompt);
        list.add(0,comboTreeModel);
        return  list;
    }
}
