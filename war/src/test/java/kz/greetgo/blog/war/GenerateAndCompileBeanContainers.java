package kz.greetgo.blog.war;

import kz.greetgo.depinject.gen.DepinjectUtil;

public class GenerateAndCompileBeanContainers {
  public static void main(String[] args) throws Exception {
    String outDir = args.length < 1 ? "build/gen_java_out_dir" : args[0];
    DepinjectUtil.implementBeanContainers("kz.greetgo.blog", outDir);
  }
}
