package kz.greetgo.blog.stand.launcher;

import kz.greetgo.blog.stand.utils.Modules;
import kz.greetgo.depinject.gen.DepinjectUtil;

public class StandLauncher {
    public static void main(String [] args){
        new StandLauncher().run();
    }

    public static void run(){
        try {
            DepinjectUtil.implementAndUseBeanContainers("kz.greetgo.blog.stand",
                    Modules.standDir()+"build/src_bean_container");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
