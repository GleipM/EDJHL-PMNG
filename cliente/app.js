const API = 'http://32.200.110.38:8089';

onload = () => {
  obtenerDatos();
}

async function obtenerDatos() {
  try {
    const res = await fetch(`${API}/people`);
    if (!res.ok) throw new Error(`HTTP ${res.status}`);
    const data = await res.json();
    const nombres = data.data.map(persona => ({ name: persona.name }));    
    fillTable(nombres)
  } catch (err) {
    resultado.textContent = "Error: " + err.message;
  }
}

async function fillTable(personas) {
    const lista = document.getElementById('lista')
    lista.innerHTML = '';
    lista.innerHTML = '<tr><th>Nombre</th></tr>'
    personas.forEach(element => {
        const nuevaFila = document.createElement('tr')
        const celda = document.createElement('td');
        celda.textContent = element.name;

        nuevaFila.appendChild(celda);
        lista.appendChild(nuevaFila)
    });
}

document.getElementById("miForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const nombre = document.getElementById("nombre").value;
  const datos = { name: nombre };

  try {
    const res = await fetch(`${API}/people`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(datos),
      
    });
    if(res.ok){
        obtenerDatos();
    }
    if (!res.ok) throw new Error(`HTTP ${res.status}`);
    e.target.reset();
  } catch (err) {
    resultado.textContent = "Error: " + err.message;
  }
});