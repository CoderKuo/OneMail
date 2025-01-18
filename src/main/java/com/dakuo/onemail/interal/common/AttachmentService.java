package com.dakuo.onemail.interal.common;

import com.dakuo.onemail.api.account.Account;
import com.dakuo.onemail.interal.OneMailManager;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 大阔
 * @since 2025/1/17 20:53
 */
public interface AttachmentService<T> {

    String getName();

    default List<String> getAlias(){
        return new ArrayList<>();
    }

    String displayName(T attachment);

    ItemStack displayIcon(T attachment);


    boolean claim(Account account, Object attachment);

    default void register(){
        OneMailManager.registerAttachService(this);
    }



}
