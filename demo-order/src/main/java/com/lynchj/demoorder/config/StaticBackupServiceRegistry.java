package com.lynchj.demoorder.config;

import com.netflix.appinfo.DataCenterInfo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.MyDataCenterInfo;
import com.netflix.discovery.BackupRegistry;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

/**
 * @Author：大漠知秋
 * @Description：此类主要针对在项目启动之前，所有的 Eureka Server 都挂掉了，
 *                  此时连接不到注册中心，获取不到 Service Registry
 *                  当读取此配置作为 备份使用 Service Registry
 *                  当然，这种情况就比较适用于服务端提供负载均衡或者服务 ip 地址相对固定的场景
 * @CreateDate：10:35 AM 2018/10/24
 */
public class StaticBackupServiceRegistry implements BackupRegistry {

    private Applications localRegionApps = new Applications();

    public StaticBackupServiceRegistry() {
        Application orgApplication = new Application("org");
        InstanceInfo orgInstancel1 = InstanceInfo.Builder.newBuilder()
                .setAppName("demo-goods")
                .setVIPAddress ("demo-goods")
                .setSecureVIPAddress ("demo-goods")
                .setInstanceId("demo-instance-1")
                .setHostName("127.0.0.1")
                .setIPAddr("127.0.0.1")
                .setPort(11200)
                .setDataCenterInfo(new MyDataCenterInfo(DataCenterInfo.Name.MyOwn))
                .setStatus(InstanceInfo.InstanceStatus.UP)
                .build();
        InstanceInfo orgInstancel2 = InstanceInfo.Builder.newBuilder()
                .setAppName("demo-goods")
                .setVIPAddress ("demo-goods")
                .setSecureVIPAddress ("demo-goods")
                .setInstanceId("demo-instance-2")
                .setHostName("127.0.0.1")
                .setIPAddr("127.0.0.1")
                .setPort(11201)
                .setDataCenterInfo(new MyDataCenterInfo(DataCenterInfo.Name.MyOwn))
                .setStatus(InstanceInfo.InstanceStatus.UP)
                .build();
        orgApplication.addInstance(orgInstancel1);
        orgApplication.addInstance(orgInstancel2);
        localRegionApps.addApplication(orgApplication);
    }

    @Override
    public Applications fetchRegistry() {
        return localRegionApps;
    }

    @Override
    public Applications fetchRegistry(String[] includeRemoteRegions) {
        return localRegionApps;
    }

}
