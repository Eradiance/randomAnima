const getAllAnimaList = () => {
    clearTable();
    const URL = window.location.host;
    console.log("http://" + URL +"/api/")
    fetch("http://" + URL +"/api/")
        .then(response => response.json())
        .then(listOfAnima => {
            const tbodyElement = document.getElementById("ListOfAnima")
        listOfAnima.forEach(anima =>{
            tbodyElement.append(addAnimaOnPage(anima));
        })
    })
}

const addAnimaOnPage = (anima) =>{
    const trElement = document.createElement("tr");
    const title = document.createElement("td");
    const series = document.createElement("td");
    title.innerHTML = anima.title;
    series.innerHTML = anima.countSeries;
    trElement.append(title);
    trElement.append(series);
//    trElement.setAttribute("onclick", console.log("bim bim bom bom"))
    return trElement;
}

const clearTable = () => {
    const table = document.getElementById("ListOfAnima");
    table.innerHTML = '';
};
const addAnimaOnServer = async () => {
    title = document.getElementById("title");
    series = document.getElementById("series");
    const url = "http://localhost:8080/api/addAnima?" + "title=" + title.value + "&" + "series=" + series.value;
    try {


        await fetch(url, {method: 'Post'});
        console.log("http://localhost/api/addAnima?" + "title=" + title + "&" + "series=" + series);
        //setTimeout(() =>{console.log("anima: " + title.value + " added")}, 10000);
        getAllAnimaList();
    } catch (error) {
        console.error("Ошибка при отправке запроса: "  + error);
    }
}

const removeAnimaOnServer = () => {
    title = document.getElementById("title");
    const url = "http://localhost:8080/api/?" + "title=" + title.value;
    let response = fetch(url, {method: 'Delete'});
    getAllAnimaList();
}

const randomAnima = () => {
    const URL = window.location.host;
    const apiUrl = "http://" + URL +"/api/randomAnima";

    fetch(apiUrl)
        .then(response => response.json())
        .then(animaList => {
            const container = document.getElementById("animaContainer");
            container.innerHTML = "";

            const circleContainer = document.createElement('div');
            circleContainer.classList.add("circle-container");
            container.appendChild(circleContainer);

            animaList.forEach((anima, index) => {
                const circle = createCircle(index + 1, anima);
                circleContainer.appendChild(circle);
            });
        })
        .catch(error => {
            console.error("Ошибка при получении данных:", error);
        });
};

const createCircle = (number, anima) => {
    const circle = document.createElement("div");
    circle.classList.add("circle");
    circle.textContent = number;

    circle.addEventListener("click", () => {
        alert(anima.title);
    });

    return circle;
};



const shuffleArray = (array) => {
    const shuffledArray = [...array];
    for (let i = shuffledArray.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [shuffledArray[i], shuffledArray[j]] = [shuffledArray[j], shuffledArray[i]];
    }
    return shuffledArray;
};