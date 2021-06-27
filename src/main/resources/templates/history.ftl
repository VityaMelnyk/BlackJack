<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <meta charset="UTF-8">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/style/history.css'/>"/>
    <title>History</title>

</head>
<body style="background-color: #22222deb">
<div class="tittle" style="display: flex; justify-content: center">
<h1 style="color: #F9FF0D">History</h1>
</div>
<div>

    <table class="table table-hover table-dark">
        <thead>
        <tr>
            <th>id</th>
            <th>Ім'я гравця</th>
            <th>Час</th>
            <th>Перегляд</th>
        </tr>
        </thead>
        <tbody>
        <#list rounds as element>
            <tr>
                <td>${element.id}</td>
                <td>${element.userName}</td>
                <td>${element.start}</td>
                <td><a class="btn btn-outline-light" style="border: 0" href="/web/cards/history/${element.id}">Переглянути</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<div class="button-home" style="display: flex; justify-content: center; margin-bottom: 10px;">
    <a class="badge bg-info text-dark" href="/index.html">Home</a>
</div>

</body>
</html>