package learning.libs.guava.join;

import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        String prod = "-Xms18g -Xmx35g -XX:PermSize=768m -XX:MaxPermSize=1g -XX:NewSize=1g -XX:MaxNewSize=1g -XX:+UseCodeCacheFlushing -XX:+PrintGCDetails -XX:ReservedCodeCacheSize=96m -verbose:gc -XX:+DisableExplicitGC -Datg.dynamo.server.name=MStore-weblogic-split-batch -Djavax.xml.soap.MessageFactory=com.sun.xml.messaging.saaj.soap.MessageFactoryImpl -Djavax.xml.soap.SOAPFactory=com.sun.xml.messaging.saaj.soap.SOAPFactoryImpl -Djavax.xml.soap.MetaFactory=com.sun.xml.messaging.saaj.soap.SAAJMetaFactoryImpl -Dtangosol.coherence.cacheconfig=/app/coherence/server-config-prod.xml -Dtangosol.coherence.distributed.localstorage=false -Dtangosol.pof.enabled=true -Dtangosol.pof.config=mvideo-pof-configuration.xml -Dtangosol.coherence.override=/app/coherence/cluster-config-prod.xml -Dtangosol.coherence.member=PRODWeblogicServerBatchA -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=13010 -Djava.rmi.server.hostname=10.220.4.63 -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Djavax.management.builder.initial=weblogic.management.jmx.mbeanserver.WLSMBeanServerBuilder -XX:+UseConcMarkSweepGC -XX:+CMSIncrementalMode -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+PrintPromotionFailure -Xloggc:/app/weblogic/user_projects/domains/domain-prod/batch-server.gc -Ddisable.atg.dynamo.log=true -XX:CMSInitiatingOccupancyFraction=70 -XX:+UseCMSInitiatingOccupancyOnly -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/app/weblogic/user_projects/domains/domain-prod/ATG-Data/logs -XX:+ParallelRefProcEnabled -javaagent:/app/appdyn/AppServerAgent-4.5.4.24355/javaagent.jar";
        String nft = "-Xms18g -Xmx18g -XX:PermSize=768m -XX:MaxPermSize=1g -XX:NewSize=1g -XX:MaxNewSize=1g -XX:+UseCodeCacheFlushing -XX:ReservedCodeCacheSize=96m -XX:CMSInitiatingOccupancyFraction=70 -XX:+UseCMSInitiatingOccupancyOnly -Datg.dynamo.server.name=MStore-weblogic-split-batch -Djavax.xml.soap.MessageFactory=com.sun.xml.messaging.saaj.soap.MessageFactoryImpl -Djavax.xml.soap.SOAPFactory=com.sun.xml.messaging.saaj.soap.SOAPFactoryImpl -Djavax.xml.soap.MetaFactory=com.sun.xml.messaging.saaj.soap.SAAJMetaFactoryImpl -Dtangosol.coherence.cacheconfig=/app/coherence/server-config-nft.xml -Dtangosol.coherence.distributed.localstorage=false -Dtangosol.pof.enabled=true -Dtangosol.pof.config=mvideo-pof-configuration.xml -Dtangosol.coherence.override=/app/coherence/cluster-config-nft.xml -Dtangosol.coherence.member=NFTWeblogicServerBatchA -XX:+UseConcMarkSweepGC -XX:+CMSIncrementalMode -XX:+DisableExplicitGC -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -verbose:gc -Xloggc:/app/weblogic/user_projects/domains/domain-nft/batch-server.gc -Djava.util.logging.config.file=/app/weblogic/user_projects/domains/domain-nft/logging.properties -Dtangosol.coherence.management.extendedmbeanname=true -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=13010 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.local.only=false -Djavax.management.builder.initial=weblogic.management.jmx.mbeanserver.WLSMBeanServerBuilder  -XX:+PrintGCDateStamps -XX:+PrintPromotionFailure -Ddisable.atg.dynamo.log=true -XX:+HeapDumpOnOutOfMemoryError -XX:+ParallelRefProcEnabled -XX:HeapDumpPath=/app/weblogic/user_projects/domains/domain-nft/ATG-Data/logs -javaagent:/app/appdynamics/AppServerAgent-4.5.0.23604/javaagent.jar -Dappdynamics.agent.log4j2.disabled=true";
        compareSettings(prod, nft);
    }

    private static void compareSettings(String prod, String nft) {
        nft = nft.replace("nft", "prod");
        nft = nft.replace("NFT", "PROD");
        List<String> prodA = split(prod);
        List<String> nftA = split(nft);
        System.out.println(prodA);
        System.out.println(nftA);

        prodA.removeAll(nftA);
        System.out.println("Diff between prod and nft:");
        System.out.println(prodA);
    }

    private static List<String> split(String prod) {
        List<String> res = Splitter.on(' ')
                .omitEmptyStrings()
                .trimResults()
                .splitToList(prod);

        List<String> list = new ArrayList<>(res); //because res is java.util.Collections$UnmodifiableRandomAccessList

        list.sort(String.CASE_INSENSITIVE_ORDER);

        return list;
    }

}
