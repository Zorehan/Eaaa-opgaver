const MOUNTAINS = [
    {name: "Kilimanjaro", height: 5895, place: "Tanzania"},
    {name: "Everest", height: 8848, place: "Nepal"},
    {name: "Mount Fuji", height: 3776, place: "Japan"},
    {name: "Vaalserberg", height: 323, place: "Netherlands"},
    {name: "Denali", height: 6168, place: "United States"},
    {name: "Popocatepetl", height: 5465, place: "Mexico"},
    {name: "Mont Blanc", height: 4808, place: "Italy/France"}
];

const bodyNode = document.body;

let tableNode = document.createElement("table");
const trHeaderNode = document.createElement("tr");
const thMountainNode = document.createElement("th");
thMountainNode.appendChild(document.createTextNode("Mountain"));
trHeaderNode.appendChild(thMountainNode);
const thHeightNode = document.createElement("th");
thHeightNode.appendChild(document.createTextNode("Height"));
trHeaderNode.appendChild(thHeightNode);
const thPlaceNode = document.createElement("th");
thPlaceNode.appendChild(document.createTextNode("Place"));
trHeaderNode.appendChild(thPlaceNode);

tableNode.appendChild(trHeaderNode);

for (let mountain of MOUNTAINS) {
    const trNode = document.createElement("tr");

    const tdMountainNode = document.createElement("td");
    tdMountainNode.appendChild(document.createTextNode(mountain.name));
    trNode.appendChild(tdMountainNode);

    const tdHeightNode = document.createElement("td");
    tdHeightNode.appendChild(document.createTextNode(mountain.height));
    trNode.appendChild(tdHeightNode);

    const tdPlaceNode = document.createElement("td");
    tdPlaceNode.appendChild(document.createTextNode(mountain.place));
    trNode.appendChild(tdPlaceNode);

    tableNode.appendChild(trNode);
}

bodyNode.appendChild(tableNode);
