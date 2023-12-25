
const websocket = new WebSocket("ws://localhost:8080/ws/chat");
    websocket.onopen = function (e) {
        console.log("open");
    };

    //데이터 보낼때
    const gameStartButton = () => {
        let message = "START";
        websocket.send(JSON.stringify(message));
        console.log(JSON.stringify(message));
    }


//    const sendM = function() {
//        let sendMessage = document.getElementsByName("message")[0].value;
//        if (sendMessage != "") {
////            let text = {
////                'receiverId' : receiverId,
////                'message' : message,
////            }
//            if (sendMessage != null) {
//                websocket.send(JSON.stringify(sendMessage));
//            }
//            document.getElementsByName("message")[0].value = '';
//            document.getElementById("receivedMessage").innerHTML = 'sended!';
//        } else {
//        alert("Empty Message");}
//    }

    let result;
    let price;

    // 데이터를 수신 받았을 때
    websocket.onmessage = async function (e) {
        console.log(e.data)
        try {
            if (e !== null && e !== undefined) {
                result = e.data;
                price = result[0];
                document.getElementById("receivedMessage").innerHTML = JSON.parse(e.data).command;
                if(JSON.parse(e.data).command == "CONNECTED") {
                    document.getElementById("receivedMessage").innerHTML = "게임룸이 생성되었습니다. 당신은 호스트입니다. 상대방을 기다리는 중 입니다.";
                } else if (JSON.parse(e.data).command == "READY") {
                    document.getElementById("receivedMessage").innerHTML = "게임을 할 준비가 되었습니다. '게임시작'버튼을 눌러주세요.";
                    document.getElementById("gameStart").style.display = 'block';
                } else if (JSON.parse(e.data).command == "WAITING") {
                    document.getElementById("receivedMessage").innerHTML = "게임을 할 준비가 되었습니다. 당신은 플레이어 입니다. 호스트를 기다려주세요.";
                } else if (JSON.parse(e.data).command == "START") {
                    document.getElementById("receivedMessage").innerHTML = "게임을 시작합니다.";
                }

            }
        } catch (err) {
            console.log(err);
        }
    };

    // 에러가 발생했을 때
    websocket.onerror = function (e) {
        console.log(e);
    };

