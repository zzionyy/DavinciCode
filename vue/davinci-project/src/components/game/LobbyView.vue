<template>
    <div class="container">
        <div class="top">
            <div class="rooms">
                <div>Room1</div>
                <div>Room2</div>
                <div>Room1</div>
                <div>Room3</div>
                <div>Room1</div>
                <div>Room4</div>
                <div>Room1</div>
                <div>Room3</div>
                <div>Room1</div>
                <div>Room5</div>
                <div>Room6</div>
                <div>Room1</div>
                <div>Room2</div>
                <div>Room1</div>
                <div>Room1</div>
            </div>
            <div class="userPart">
                유저 정보입니다.
            </div>
        </div>
        
    </div>

</template>

<script setup>

</script>

<style>
* {
    box-sizing: border-box;
    margin: 10px;
    padding: 5px;
}
.container {
    width: 90%;
    height: 70%;
    display: flex;
    background-color: gray;
    border: 1px solid gainsboro;
    flex-direction: row;
    align-items: center;
    
}

.top {
    display: flex;
    flex-direction: row;
    justify-content: center;
    width: 90%;
    height: 90%;
}
.rooms {
    width: 70%;
    display: inherit;
    flex-direction: column;
    background-color: whitesmoke;
    border: 1px solid black;
    overflow-y: auto;
    height: 200px;
}
.userPart {
    width: 40%;
    background-color: pink;
}
</style>