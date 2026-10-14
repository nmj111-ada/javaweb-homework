<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>第一回 - 三国演义</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>第一回 宴桃园豪杰三结义 斩黄巾英雄首立功</h1>
            <div class="theme-switcher">
                <label for="themeSelect">选择主题：</label>
                <select id="themeSelect">
                    <option value="light">浅色背景</option>
                    <option value="dark">深色背景</option>
                </select>
            </div>
        </header>

        <article class="chapter-content">
            <p>……话说天下大势，分久必合，合久必分。……</p>
            <p>（此处仅为示例内容，可自行添加）</p>

            <!-- 插图，路径为 images/chapter1.jpg -->
            <div class="illustration">
                <img src="images/chapter1.jpg" alt="桃园三结义" style="max-width:100%; border-radius:8px;">
                <p>插图：桃园三结义</p>
            </div>

            <p>……次日，于桃园中，备下乌牛白马祭礼等项，三人焚香再拜而说誓……</p>
        </article>

        <div class="back-link">
            <a href="index.jsp">← 返回目录</a>
        </div>
    </div>

    <script src="theme.js"></script>
</body>
</html>