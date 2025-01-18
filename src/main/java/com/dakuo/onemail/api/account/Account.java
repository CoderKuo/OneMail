package com.dakuo.onemail.api.account;

import com.dakuo.onemail.api.mail.Mail;
import com.dakuo.onemail.interal.OneMailManager;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Index
 * */
public class Account {

    private final UUID id;
    private final String name;

    public Account(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * @return List<String> 获取账户所有邮件组
     * */
    public List<String> getMailGroups(){
        return OneMailManager.getService().getAccountGroups(id);
    }

    /**
     * @return Optional<String> 获取账户默认邮件组
     * */
    public Optional<String> getDefaultGroup(){
        return OneMailManager.getService().getDefaultGroup(id);
    }

    /**
     * @param groupId String 邮件组ID
     * @param mail Mail 邮件
     * 向接收者的邮件组ID发送邮件
     * */
    public boolean sendMail(String groupId, Mail mail){
        return OneMailManager.getService().sendMail(id,groupId,mail);
    }

    /**
     * @param receiver Account 接收者账户
     * @param mail Mail 邮件
     * 向接收者默认邮件组发送邮件
     * */
    public boolean sendMail(Account receiver, Mail mail){
        return OneMailManager.getService().sendMail(id,receiver.getDefaultGroup().orElse(null),mail);
    }

    /**
     * @param includeRead boolean 是否包含已读邮件
     * @param groupId String 邮件组ID
     * @return List<Mail> 获取账户邮件组内邮件
     * */
    public List<Mail> getMails(String groupId, boolean includeRead){
        return OneMailManager.getService().getAccountGroupMails(id,groupId,includeRead);
    }

    /**
     * @param mailId UUID 邮件ID
     * @return boolean 查询是否包含指定UUID的邮件
     * */
    public boolean hasMail(UUID mailId){
        return OneMailManager.getService().isMailExist(id,mailId);
    }

    /**
     * @param mailId UUID 邮件ID
     * @return boolean 标记成功
     * 标记邮件已读
     * */
    public boolean markAsRead(UUID mailId){
        return OneMailManager.getService().markMailRead(id,mailId);
    }

    /**
     * 标记所有邮件已读
     * */
    public void markAllAsRead(){
        OneMailManager.getService().markAllMailRead(id);
    }

    /**
     * @return List<UUID> 领取失败邮件UUID列表
     * 领取所有附件
     * */
    public List<UUID> claimAllAttachments(){
        return OneMailManager.getService().claimAllAttachments(id);
    }

    /**
     * @param mailId UUID 邮件ID
     * @return boolean 领取成功
     * 领取邮件附件
     * */
    public boolean claimAttachments(UUID mailId){
        return OneMailManager.getService().claimAttachments(id,mailId);
    }

}
