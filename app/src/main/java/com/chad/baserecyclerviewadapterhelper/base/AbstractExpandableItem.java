package com.chad.baserecyclerviewadapterhelper.base;

import androidx.core.util.ObjectsCompat;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 多级树形结构
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2019/11/7 19:32
 */
public abstract class AbstractExpandableItem<T> implements IDefaultExpand<T>, MultiItemEntity {
    /**
     * 父节点
     */
    public static final int ITEM_TYPE_PARENT = 0x1101;
    /**
     * 子节点
     */
    public static final int ITEM_TYPE_CHILD = 0x1102;
    /**
     * 是否展开
     */
    private boolean mExpandable = false;
    /**
     * 项目类型
     */
    private int itemType;

    /**
     * 路径的深度
     */
    private int treeDepth = 0;
    /**
     * 默认展开
     */
    private boolean isDefaultExpend;
    /**
     *
     */
    private boolean enabledDefaultExpend;

    @Override
    public boolean isExpanded() {
        return mExpandable;
    }

    @Override
    public void setExpanded(boolean mExpandable) {
        this.mExpandable = mExpandable;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getLevel() {
        return itemType;
    }

    @Override
    public boolean isDefExpanded() {
        return isDefaultExpend;
    }

    @Override
    public void setDefExpanded(boolean expanded) {
        this.isDefaultExpend = expanded;
    }

    @Override
    public boolean enabledDefaultExpend() {
        return enabledDefaultExpend;
    }

    @Override
    public void setEnabledDefaultExpand(boolean enabled) {
        this.enabledDefaultExpend = enabled;
    }

    @Override
    public int spitCount() {
        return 6;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> subItems = getSubItems();
        if (hasSubItem()) {
            if (fromIndex >= subItems.size() || toIndex > subItems.size()) {
                return subItems;
            }
            return subItems.subList(fromIndex, toIndex);
        }
        return new ArrayList<>();
    }

    @Override
    public int getAllCount() {
        return hasSubItem() ? getSubItems().size() : 0;
    }

    public int getTreeDepth() {
        return treeDepth;
    }

    public void setTreeDepth(int treeDepth) {
        this.treeDepth = treeDepth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractExpandableItem<?> that = (AbstractExpandableItem<?>) o;
        return mExpandable == that.mExpandable &&
                itemType == that.itemType &&
                treeDepth == that.treeDepth &&
                isDefaultExpend == that.isDefaultExpend &&
                enabledDefaultExpend == that.enabledDefaultExpend;
    }

    @Override
    public int hashCode() {
        return ObjectsCompat.hash(mExpandable, itemType, treeDepth, isDefaultExpend, enabledDefaultExpend);
    }

    /**
     * 获取选中的item
     *
     * @author dingpeihua
     * @date 2019/11/14 10:47
     * @version 1.0
     */
    public List<T> getCheckedSubItems() {
        return null;
    }
}
