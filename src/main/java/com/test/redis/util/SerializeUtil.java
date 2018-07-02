package com.test.redis.util;

import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 上官炳强
 * @description
 * @since 2018-06-30 / 06:48:32
 */
@Component
public class SerializeUtil<E> {
    public  byte[] serialize(E o) {

        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            //序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public  E unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            //反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (E) ois.readObject();
        } catch (Exception e) {
        }
        return null;
    }

    public  List<byte[]> serializeList(List<E> list) {
        List<byte[]> bytes = new ArrayList<>();
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            //序列化集合中的元素
            for (Object o : list) {
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(o);
                byte[] b = baos.toByteArray();
                bytes.add(b);
            }
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public  List<E> unserializeList(List<byte[]> bytes) {
        List<E> os = new ArrayList<>();
        ByteArrayInputStream bais = null;
        try {
            //反序列化集合中的元素
            for (byte[] aByte : bytes) {
                bais = new ByteArrayInputStream(aByte);
                ObjectInputStream ois = new ObjectInputStream(bais);
                E o =(E) ois.readObject();
                os.add(o);
            }
            return os;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
