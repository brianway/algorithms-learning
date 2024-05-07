package com.brianway.learning.algorithms.company.huawei;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
DHCP服务器的功能是为每一个MAC地址分配唯一的IP地址。现假设：分配的IP地址范围从 192.168.0.0 到 192.168.0.255 总共256个可用地址（以点分十进制表示）。请实现一个简易的DHCP服务器，功能如下：

分配Request：根据输入的MAC地址分配IP地址池中的IP地址：
如果对应的IP已分配并未释放，则为重复申请，直接返回对应已分配的IP地址。
如果一个MAC地址已申请过并已释放，即：当前未分配IP地址，则为再申请，优先分配最近一次曾经为其分配过的IP地址，请返回此地址。
按升序分配从未被分配过的IP地址；如果地址池中地址都已被分配过，则按升序分配已释放出来的IP地址；若可分配成功，则返回此IP地址。
若仍然无法分配成功，则返回NA。

释放Release：根据输入的MAC地址释放已分配的IP地址：
如果申请释放的对应的IP地址已分配，则释放此IP地址；
如果申请释放的对应的IP地址不存在，则不作任何事情；
解答要求
时间限制：1000ms, 内存限制：64MB
输入
首行为整数n, 表示其后输入的命令行数，范围[1,2000]。
之后每行为一条分配命令，格式为：命令=MAC地址

命令只有两种：REQUEST 和 RELEASE，分别表示分配和释放；
MAC地址为：12个大写英文字母或数字，如：AABBCCDDEEF1。
输出
1.REQUEST命令，输出分配结果(IP地址字符串或字符串NA)，均为字符串形式。


注意：IP地址的各区段不设置前置 0

2.RELEASE命令，不输出任何内容。

样例
输入样例 1

2
REQUEST=AABBCCDDEEF1
RELEASE=AABBCCDDEEF1
输出样例 1

192.168.0.0
提示样例 1
REQUEST=AABBCCDDEEF1 按升序分配从未使用过的IP地址，输出192.168.0.0
RELEASE=AABBCCDDEEF1 不输出



输入样例 2

6
REQUEST=AABBCCDDEEF1
REQUEST=F2FBBCCDDEEF
RELEASE=AABBCCDDEEF1
RELEASE=F2FBBCCDDEEF
REQUEST=333333333333
REQUEST=F2FBBCCDDEEF
输出样例 2

192.168.0.0
192.168.0.1
192.168.0.2
192.168.0.1
提示样例 2
REQUEST=AABBCCDDEEF1 按升序分配从未使用过的IP，为192.168.0.0
REQUEST=F2FBBCCDDEEF 按升序分配从未使用过的IP，为192.168.0.1
RELEASE=AABBCCDDEEF1 释放IP 192.168.0.0。
RELEASE=F2FBBCCDDEEF 释放IP 192.168.0.1。
REQUEST=333333333333 按升序分配从未使用过的IP，为192.168.0.2
REQUEST=F2FBBCCDDEEF 该MAC地址再申请，优先分配最近一次曾经为其分配过的IP，为192.168.0.1
 */

/**
 * @auther brian
 * @since 2023/2/3 21:09
 */
public class Huawei {

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        DhcpServer dhcpServer = new DhcpServer();
        int operationCnt = cin.nextInt();
        for (int i = 0; i < operationCnt; i++) {
            String[] operation = cin.next().split("=");
            if ("REQUEST".equals(operation[0])) {
                System.out.println(dhcpServer.request(operation[1]));
            } else {
                dhcpServer.release(operation[1]);
            }
        }
        cin.close();
    }

    static class DhcpServer {
        // 活跃map, key:mac, value:ip
        Map<String, String> activeMap = new HashMap<>(256);

        // 上一次释放map, key:mac, value:ip
        Map<String, String> latestReleaseMap = new HashMap<>(256);

        // 可用ip列表, 用最后一位表示。
        List<String> remainIps = new ArrayList<>(256);

        // cursor [0,255]
        // 下一个可分配的ip最后一位，范围 [192.168.0.0, 192.168.0.255]
        int cursor = 0;

        DhcpServer() {
            // init remainIps
            for (int i = 0; i < 255; i++) {
                String ip = "192.168.0." + i;
                remainIps.add(ip);
            }
        }

        String request(String mac) {
            // 已分配
            if (activeMap.get(mac) != null) {
                return activeMap.get(mac);
            }

            // 未分配

            // 优先最近一次
            String lastestIp = latestReleaseMap.get(mac);
            if (lastestIp != null && remainIps.contains(lastestIp)) {
                assignIp(mac, lastestIp);
                return lastestIp;
            }

            // 分配完了
            if (remainIps.size() == 0) {
                return "NA";
            }

            if (cursor <= 255) {
                // 未分配完，分配下一个
                String ip = "192.168.0." + cursor;
                cursor++;
                assignIp(mac, ip);

                return ip;
            }

            // 打完过一圈，按升序分配释放的
            String ip = remainIps.get(0);
            assignIp(mac, ip);

            return ip;
        }

        void release(String mac) {
            String ip = activeMap.get(mac);
            // 如果申请释放的对应的IP地址不存在，则不作任何事情；

            if (ip == null) {
                return;
            }

            // 存在
            activeMap.remove(mac);
            latestReleaseMap.put(mac, ip);
            remainIps.add(ip);
            // sort
            remainIps = remainIps.stream().sorted().collect(Collectors.toList());

        }

        void assignIp(String mac, String ip) {
            activeMap.put(mac, ip);
            remainIps = remainIps.stream().filter(rip -> !rip.equals(ip)).collect(Collectors.toList());
        }

    }
}

