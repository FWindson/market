package com.market.java.extendsion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ListIterator;
import java.util.List;

public class LinqArrayList<T> extends ArrayList<T> {

	private static final long serialVersionUID = -5042194313851746204L;

	public LinqArrayList(){
        super();
    }
	
	public LinqArrayList(Collection<? extends T> c){
        super(c);
    }
     
    /**
     * 查找首条符合条件的记录
     * @param predicate 条件
     * @return
     */
    public T find(Predicate<T> predicate){
        for(T item: this){
            if(predicate.evaluate(item)){
                return item;
            }
        }
        return null;
    }
     
    /**
     * 按条件删除
     * @param predicate
     */
    public void remove(Predicate<T> predicate){
         ListIterator<T> i = this.listIterator();
         while(i.hasNext()){
             T c = i.next();
             if(predicate.evaluate(c)){
                 i.remove();
             }
         }
    }
     
    class ComparableItem<T> implements Comparable{
 
        T data;
        Func<T,  ?> keySelect =null;
        public  <T2 extends Comparable<? super T2>> ComparableItem(T item,Func<T,T2> keySelect){
            this.keySelect = keySelect;
            this.data = item;
        }
         
        @Override
        public int compareTo(Object o) {
            return ((Comparable)(this.keySelect.process(this.data))).compareTo((Comparable)(this.keySelect.process(((ComparableItem<T>)o).data)));
        }
         
    }
     
    /**
     * 选择
     * @param keySelect
     * @return
     */
    public <T2> LinqArrayList<T2> select(Func<T,T2> keySelect){
        LinqArrayList<T2> result = new LinqArrayList<T2>();
        for(T item : this){
            result.add(keySelect.process(item));
        }
        return result;
    }
     
    /**
     * 按指定字段排序
     * @param keySelect（选择排序的字段）
     */
    public <T2 extends Comparable<? super T2>> void sort(Func<T,T2> keySelect){
        List<ComparableItem<T>> items = new ArrayList<ComparableItem<T>>();
        for(T item : this){
            items.add(new ComparableItem<T>(item, keySelect));
        }
       Collections.sort(items);
       ListIterator i = this.listIterator();
        for (int j=0; j<items.size(); j++) {
            i.next();
            i.set(items.get(j).data);
        }
    }
     
    /**
     * 查找所有符合条件的记录
     * @param predicate
     * @return
     */
    public LinqArrayList<T> findAll(Predicate<T> predicate){
        LinqArrayList<T> result = new LinqArrayList<T>();
        for(T item: this){
            if(predicate.evaluate(item)){
                result.add(item);
            }
        }
        return result;
    }
     
    /**
     * 是否存在
     * @param predicate
     * @return
     */
    public boolean exist(Predicate<T> predicate){
        return this.find(predicate)!=null;
    }
	
}
