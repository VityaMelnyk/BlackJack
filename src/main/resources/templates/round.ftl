<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/style/round.css'/>"/>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="container">
<div class="score">
<h1>${round.userName}</h1>
<h1>${round.score}</h1>
<h1>${round.start}</h1>
</div>
<#--<table class="table table-hover table-dark">-->
        <li>id</li>
    <#list delivery as element>
            <li>${element.value}</li>
    </#list>
<#--</table>-->
</div>
</body>
</html>