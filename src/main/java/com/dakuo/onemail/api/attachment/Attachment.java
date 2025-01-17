package com.dakuo.onemail.api.attachment;

import org.bukkit.inventory.ItemStack;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Index
 * */
public interface Attachment extends Serializable {
    /**
     * @return String 获取附件显示名称
     * */
    String getDisplayName();

    /**
     * @return AttachmentIdentifier 获取附件标识
     * */
    AttachmentIdentifier getIdentifier();

    ItemStack getDisplayItem();

    /**
     * @param receiver 领取者UUID
     * @return 是否领取成功
     */
    boolean claim(UUID receiver);
}
