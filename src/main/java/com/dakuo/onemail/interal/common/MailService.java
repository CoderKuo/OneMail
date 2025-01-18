package com.dakuo.onemail.interal.common;

import com.dakuo.onemail.api.account.Account;
import com.dakuo.onemail.api.mail.Mail;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author 大阔
 * @since 2025/1/17 20:15
 */
public interface MailService {

    public Account createAccount(UUID uid,String displayName);

    public Account getSystemAccount();

    public Account getAccount(UUID uid);

    public Account getAccount(String name);

    public List<String> getAccountGroups(UUID uid);

    public Optional<String> getDefaultGroup(UUID uid);

    public boolean isAccountExist(UUID uid);

    public boolean isAccountExist(String name);

    public boolean isMailExist(UUID uid);

    public boolean isMailExist(UUID uid,UUID mailUID);

    public boolean isMailGroupExist(UUID uid,String groupId);

    public List<Mail> getAccountGroupMails(UUID uid,String groupId,boolean isRead);

    public boolean markMailRead(UUID uid,UUID mailUID);

    public boolean markAllMailRead(UUID uid);

    public boolean deleteMail(UUID uid,UUID mailUID);

    public boolean sendMail(UUID uid,String groupId,Mail mail);

    public boolean sendMail(UUID uid,Mail mail);

    public boolean claimAttachments(UUID uid,UUID mailUID);

    public List<UUID> claimAllAttachments(UUID uid);

}
