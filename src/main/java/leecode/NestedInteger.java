package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wujianchao on 2020/7/16.
 */
public class NestedInteger {

    private int integer;
    private List<NestedInteger> list = new ArrayList<>();

    public NestedInteger(){

    }

    public NestedInteger(int integer){
        this.integer = integer;
    }

    public boolean isInteger(){
        return list.isEmpty();
    }

    public Integer getInteger(){
        return integer;
    }

    public void setInteger(int value){
        this.integer = value;
    }

    public void add(NestedInteger ni){
        list.add(ni);
    }

    public List<NestedInteger> getList(){
        return new ArrayList<>(list);
    }

}
