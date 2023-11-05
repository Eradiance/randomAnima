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
const addAnimaOnServer = () => {
    title = document.getElementById("title");
    series = document.getElementById("series");
    const url = "http://localhost:8080/api/addAnima?" + "title=" + title.value + "&" + "series=" + series.value;
    let response = fetch(url, {method: 'Post'});
    console.log("http://localhost/api/addAnima?" + "title=" + title + "&" + "series=" + series);
    getAllAnimaList();
}

const removeAnimaOnServer = () => {
    title = document.getElementById("title");
    const url = "http://localhost:8080/api/?" + "title=" + title.value;
    let response = fetch(url, {method: 'Delete'});
    getAllAnimaList();
}
