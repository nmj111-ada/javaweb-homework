# JavaWeb 课程作业合集

这是我（`song1`）大学期间 Java 与 JavaWeb 课程的实验作业与练习项目归档。

原本这些项目存放在 Eclipse 的工作空间里（`D:\eclipse web workplace` 和 `D:\eclipse workplace`）。
因为已经不再使用 Eclipse，我把它们整理归档到本仓库，然后删除了 Eclipse IDE。

---

## 目录结构

```
javaweb-homework/
├── javaweb/          # JavaWeb（JSP / Servlet）项目
│   ├── Chapt_01/             # 课程表 JSP 页面
│   ├── HotAirBalloon/        # Cesium 3D 热气球环游
│   ├── RomanceOfThreeKingdoms/  # 三国演义在线阅读（含主题切换）
│   ├── Servers/              # Tomcat v9 服务器配置
│   ├── web shiyan/           # Web 实验（空脚手架）
│   └── yanghui/              # 杨辉三角 + MD5 Servlet
└── java/             # Java 控制台程序（实验报告）
    ├── 实验4/                 # 尼龙圈（Shiyanneironhoops）
    ├── shiyan2/              # 尼龙练习 1-3
    ├── shiyan3/              # 尼龙练习 1-2
    ├── shiyan5/              # 战斗单元模拟（抽象类 + 继承）
    └── shiyan6/              # 银行账户系统（接口 + 多态）
```

---

## 项目说明

### javaweb/ — JSP / Servlet 项目

| 项目 | 技术点 | 说明 |
|------|--------|------|
| **Chapt_01** | JSP、CSS | 2025-2026 第 2 学期个人课程表页面，表格用 CSS 美化了斑马纹和悬停效果 |
| **RomanceOfThreeKingdoms** | JSP、CSS、JavaScript | 《三国演义》在线阅读页，带封面图、简介和下拉框切换主题 |
| **yanghui** | Servlet 3.0、注解配置 | 两个 Servlet：`YangHuiServlet` 用二维数组算杨辉三角；`MD5Servlet` 用 `MessageDigest` 算 MD5，含 HTML 转义防 XSS |
| **HotAirBalloon** | CesiumJS、3D 模型 | 用 Cesium 加载 `.glb` 热气球模型做 3D 环游，右上角单选按钮切换视角 |
| **Servers** | Tomcat 配置 | Tomcat v9.0 的 `localhost-config` 服务器配置文件 |
| **web shiyan** | — | 只建了骨架，没有实际代码 |

### java/ — Java 控制台程序

| 项目 | 技术点 | 说明 |
|------|--------|------|
| **实验4** | 类与对象 | 尼龙圈问题 |
| **shiyan2** | 基础语法 | 练习 1-3 |
| **shiyan3** | 基础语法 | 练习 1-2 |
| **shiyan5** | 抽象类、继承、多态 | 战斗单元模拟，父类 `CombatUnit` + 随机扣血机制 |
| **shiyan6** | 接口、多态 | 银行账户系统：`Depositable` / `Withdrawable` / `Reportable` 三个接口，支持人民币与美元双账户存取 |

所有 Java 项目都使用 `module-info.java`（Java 模块化）。

---

## 如何运行

### Java 控制台项目

需要 **JDK 21**（原环境使用 Eclipse Temurin JDK 21）。

```bash
cd java/shiyan6/src
javac shiyan6/yinhang.java
java shiyan6.yinhang
```

### JavaWeb 项目

需要 **JDK 21** + **Tomcat 9**（这些项目用的是 `javax.servlet`，即 Servlet 3.x/4.0，**不能**直接跑在 Tomcat 10+ 上，因为 Tomcat 10 改成了 `jakarta.servlet` 包名）。

1. 用 IDEA / Eclipse 以「Dynamic Web Project」方式导入对应文件夹
2. 配置 Tomcat 9 运行
3. 访问路径：

| 项目 | 访问地址 |
|------|----------|
| Chapt_01 | `/Chapt_01/index.jsp` |
| RomanceOfThreeKingdoms | `/RomanceOfThreeKingdoms/index.jsp` |
| yanghui | `/yanghui_input.html`、`/md5_input.html` |
| HotAirBalloon | `/Hotairballoon.html` |

> **注意 HotAirBalloon 的 Cesium 库**
> 原项目里打包了完整的 CesiumJS（约 41 MB），属于第三方库，归档时已剔除。
> 如需运行，请自行下载 [CesiumJS](https://cesium.com/downloads/) 并解压到
> `javaweb/HotAirBalloon/src/main/webapp/Cesium/` 目录下，保持 `Cesium/Build/Cesium/...` 的路径结构即可。
> 自己的 3D 模型 `models/CesiumBalloon/CesiumBalloon.glb` 已保留。

---

## 归档说明

Eclipse 的 `.project`、`.classpath`、`.settings/`、`build/`、`bin/` 等 IDE 生成文件已通过 `.gitignore` 排除，仓库中只保留源码。
