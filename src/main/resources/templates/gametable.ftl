<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/style/gametable.css'/>"/>
    <link type="text/css" href="/static/style/gametable.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Fraunces:ital,wght@1,500;1,700&family=Roboto+Slab:wght@700&display=swap" rel="stylesheet">
    <title>Game Table</title>
</head>
<body>
<div class="container">
    <div class="desk">
        <div class="wrap">

            <div class="tittle-card">
            <a href="/web/cards/pick">
                <img src="/img/tittle.png" alt="1111">
            </a>
            </div>
            <div class="button-next">
            <a href="/web/cards/pick">
                <button class="badge bg-dark">PLAY</button>
            </a>
            </div>
            <a>${score}</a>
            <a>${roundCounter}</a>
        </div>
    </div>
</div>

</body>
</html>