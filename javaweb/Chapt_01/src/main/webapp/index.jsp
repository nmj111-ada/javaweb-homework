<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的课程表 - 2025-2026第2学期</title>
    <style>
        /* 在这里添加CSS样式，优化表格显示 */
        body {
            font-family: 'Microsoft YaHei', sans-serif;
            background-color: #f5f5f5;
            margin: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 90%;
            margin: 0 auto;
            border-collapse: collapse;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            background-color: white;
        }
        th {
            background-color: #4CAF50;
            color: white;
            padding: 12px;
            font-size: 16px;
        }
        td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
            vertical-align: middle;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .time-slot {
            font-weight: bold;
            background-color: #e7f3e7;
        }
        .course-name {
            font-weight: bold;
            color: #2c3e50;
        }
        .note {
            text-align: center;
            margin-top: 20px;
            color: #666;
        }
    </style>
</head>
<body>
    <h1>2025-2026学年 第2学期 课程表</h1>
    <table>
        <thead>
            <tr>
                <th>节次</th>
                <th>星期一</th>
                <th>星期二</th>
                <th>星期三</th>
                <th>星期四</th>
                <th>星期五</th>
                <th>星期六</th>
                <th>星期日</th>
            </tr>
        </thead>
        <tbody>
            <!-- 第1-2节 -->
            <tr>
                <td class="time-slot">1-2节<br><small>08:30-10:05</small></td>
                <td>大数据分析技术<br><small>南教-509</small></td>
                <td>工业互联网<br><small>南教-406</small></td>
                <td>Web开发基础<br><small>南教-301 (单周)</small></td>
                <td>Web开发基础(实验)<br><small>南教-201</small></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <!-- 第3-4节 -->
            <tr>
                <td class="time-slot">3-4节<br><small>10:25-12:00</small></td>
                <td>大数据分析技术<br><small>南教-509 (单周)</small></td>
                <td>统计学原理<br><small>南教-501 (单周)</small></td>
                <td>Android应用系统设计<br><small>南教-201 (双周)</small></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <!-- 第5-6节 (下午) -->
            <tr>
                <td class="time-slot">5-6节<br><small>14:30-16:05</small></td>
                <td>大数据安全与应用<br><small>南教-307 (2-17周)</small></td>
                <td>数据挖掘与机器学习<br><small>南教-303</small></td>
                <td>统计学原理<br><small>南教-501 (双周)</small></td>
                <td>Android应用系统设计(实验)<br><small>南教-201 (单周)</small></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <!-- 第7-8节 (下午) - 可能无课 -->
            <tr>
                <td class="time-slot">7-8节<br><small>16:25-18:00</small></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <!-- 第9-10节 (晚上) -->
            <tr>
                <td class="time-slot">9-10节<br><small>19:30-21:05</small></td>
                <td>数据挖掘与机器学习<br><small>南教-303 (单周)</small></td>
                <td></td>
                <td>形势与政策<br><small>南教-101 (11-12周)</small></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>
    <div class="note">
        
    </div>
</body>
</html>