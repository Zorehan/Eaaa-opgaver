const countries = [
    {'name': 'Danmark', 'capital': 'København'},
    {'name': 'Norge' , 'capital': 'Oslo' },
    {'name': 'Sverige' , 'capital': 'Stockholm'}
]

const bodyNode = document.body
bodyNode.style.backgroundColor = "green"

let tableNode = document.createElement("table")
const trHeaderNode = document.createElement("tr")
const thCountryNode = document.createElement("th")
const thCountryTextNode = document.createTextNode("Land")
thCountryNode.appendChild(thCountryTextNode)
trHeaderNode.appendChild(thCountryNode)

const thCapitalNode = document.createElement("th")
const thCapitalTextNode = document.createTextNode("Capital")
thCapitalNode.appendChild(thCapitalTextNode)
trHeaderNode.appendChild(thCapitalNode)





tableNode.appendChild(trHeaderNode)

for (let country of countries)
{
    const trNode = document.createElement("tr")
    trNode.appendChild(document.createElement("td")
    .appendChild(document.createTextNode(country.name)))
    trNode.appendChild(document.createElement("td")
    .appendChild(document.createTextNode(country.capital)))
    tableNode.appendChild(trNode)

}

bodyNode.appendChild(tableNode)

bodyNode.appendChild(document.createElement("h1").document.appendChild(document.createTextModel("En overskrift")))
