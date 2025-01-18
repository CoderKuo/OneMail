package com.dakuo.onemail.interal;

import com.dakuo.onemail.interal.common.AttachmentService;
import com.dakuo.onemail.interal.common.MailService;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 大阔
 * @since 2025/1/17 17:24
 */
public class OneMailManager {

    private static final CopyOnWriteArrayList<MailService> serviceList = new CopyOnWriteArrayList<>();
    private static final ConcurrentHashMap<Class<?>, AttachmentService<?>> attachmentServiceMap = new ConcurrentHashMap<>();

    public static void register(MailService mailService){
        serviceList.add(mailService);
    }

    public static <T> void registerAttachService(AttachmentService<T> service){
        attachmentServiceMap.put(service.getClass().getTypeParameters()[0].getGenericDeclaration(), service);
    }

    @SuppressWarnings("unchecked")
    public static <T> AttachmentService<T> getAttachmentService(Class<T> type){
        return (AttachmentService<T>) attachmentServiceMap.get(type);
    }

    public static MailService getService(){
        return serviceList.get(0);
    }

}
