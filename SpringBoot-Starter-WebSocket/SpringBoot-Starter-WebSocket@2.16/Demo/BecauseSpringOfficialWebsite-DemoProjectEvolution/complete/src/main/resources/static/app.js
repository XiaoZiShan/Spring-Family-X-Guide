var stompClient = null;
var socket = null;
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var headers = {
        Authorization:Math.ceil(Math.random()*100)
    }
    alert("Your this receptionName: "+headers.Authorization)
    socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect(headers,function (frame) {
        setConnected(true);

        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/topic/testuser', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    var headersx = {
        ReceiverId: $("#receptionName").val()
    }
    stompClient.send("/app/messageuser",headersx, //
        JSON.stringify({'name': $("#name").val()})
    );
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
        $("#name").val("")
    });
});

