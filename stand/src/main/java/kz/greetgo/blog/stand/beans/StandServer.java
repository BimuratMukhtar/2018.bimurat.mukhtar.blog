package kz.greetgo.blog.stand.beans;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.HasAfterInject;
import org.eclipse.jetty.server.Server;

@Bean
public class StandServer implements HasAfterInject{
    public final Server server = new Server(1314);

    @Override
    public void afterInject() throws Exception {

    }

    public StandServer start() throws Exception{
        server.start();
        System.out.println("Server Started");
        return this;
    }
}
