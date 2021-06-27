<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/style/finalDeck.css'/>"/>
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
            <#--<h1>${round}</h1>-->
            <h2 class="massage-result"> ${massageUlt} --- ${score}</h2>
            <div class="tittle-card">
                <a href="#">
                    <#--<a>${getDeckSize}</a>-->
                    <img src="/img/tittle.png" alt="1111">
                    <span class="deck-counter"> ${getDeckSize}</span>
                </a>
            </div>

            <div class="deck-list">
                <div class="player-desk">
                    <div class="player-result">
                        <div class="player-cards">
                            <#list delivery as card>
                                <li>
                                    <img src="${card.img}" alt="${card.img}">
                                </li>
                            </#list>
                        </div>
                        <h3 class="player-sum">Player ${sum}</h3>
                    </div>
                </div>
                <div class="comp-desk">
                    <div class="comp-result">
                        <div class="comp-cards">
                            <#list forComp as card>
                                <li>
                                    <img src="${card.img}" alt="${card.img}">
                                </li>
                            </#list>
                        </div>
                        <h3 class="comp-sum">Comp ${sum1}</h3>
                    </div>
                </div>
            </div>
            <div class="options">
                <div class="refresh">
                    <a href="/web/cards/refresh">
                        <button class="badge bg-warning text-dark">New game</button>
                    </a>
                    <a href="/web/cards/game">
                        <button class="badge bg-warning text-dark">Play next</button>
                    </a>
                </div>
                <div class="button-home">
                    <a class="badge bg-info text-dark" href="/index.html">Home</a>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>