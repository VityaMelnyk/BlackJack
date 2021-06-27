<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/style/stylegametable.css'/>"/>
    <link type="text/css" href="/static/style/stylegametable.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Fraunces:ital,wght@1,500;1,700&family=Roboto+Slab:wght@700&display=swap"
          rel="stylesheet">
    <title>Game Table</title>
</head>
<body>
<div class="container">
    <div class="desk">
        <div class="wrap">
            <div class="count">
                <h1>ROUND ${roundCounter}</h1>
            </div>
            <div class="tittle-card">
                <h3 class="sum">${sum}</h3>
                <div class="card-pick">
                    <a href="/web/cards/pick">
                        <img src="/img/tittle.png" alt="1111">
                        <span class="deck-counter"> ${getDeckSize}</span>
                    </a>
                </div>
            </div>
            <div class="massage" style="color: #F9FF0D;">
                <a>${massage}</a>
            </div>
            <div class="deck-list">
                <#list delivery as card>

                    <li>
                        <img src="${card.img}" alt="${card.img}">
                    </li>
                </#list>
            </div>


            <div class="button-stop">
                <a class="btn btn-danger" href="/web/cards/stop"> Stop </a>
            </div>
            <div class="home">
                <div class="button-home">
                    <a class="badge bg-info text-dark" href="/index.html">Home</a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>