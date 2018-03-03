package kz.greetgo.blog.stand.beans;

import kz.greetgo.blog.stand.utils.Modules;
import kz.greetgo.blog.stand.utils.WebAppContextRegistration;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.depinject.core.HasAfterInject;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.Comparator;
import java.util.List;

@Bean
public class StandServer implements HasAfterInject{
    public final Server server = new Server(1314);

    public StandServer start() throws Exception{
        server.start();
        System.out.println("Server Started");
        return this;
    }

    @Override
    public void afterInject() throws Exception {
        WebAppContext webAppServlet = new WebAppContext(
                Modules.clientDir().toPath().resolve(".").toString(),
                "/blog"
        );

        webAppContextRegistrations.get().stream()
                .sorted(Comparator.comparingDouble(WebAppContextRegistration::priority))
                .forEachOrdered(r -> r.registerTo(webAppServlet));

        server.setHandler(webAppServlet);
    }

    public BeanGetter<List<WebAppContextRegistration>> webAppContextRegistrations;
}
