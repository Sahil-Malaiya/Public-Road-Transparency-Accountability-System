const baseUrl = "http://localhost:8080/api/";

async function fetchData(type) {
    const url = `${baseUrl}${type}`;
    const tableContainer = document.getElementById("data-table");
    const sectionTitle = document.getElementById("section-title");

    sectionTitle.textContent = `Showing data for: ${type.charAt(0).toUpperCase() + type.slice(1)}`;
    tableContainer.innerHTML = "<p>Loading...</p>";

    try {
        const response = await fetch(url);
        const data = await response.json();

        if (data.length === 0) {
            tableContainer.innerHTML = "<p>No data available.</p>";
            return;
        }

        // Generate table headers dynamically
        const headers = Object.keys(data[0]);
        let tableHTML = "<table><thead><tr>";
        headers.forEach(h => tableHTML += `<th>${h}</th>`);
        tableHTML += "</tr></thead><tbody>";

        // Generate table rows
        data.forEach(item => {
            tableHTML += "<tr>";
            headers.forEach(h => tableHTML += `<td>${item[h]}</td>`);
            tableHTML += "</tr>";
        });

        tableHTML += "</tbody></table>";
        tableContainer.innerHTML = tableHTML;

    } catch (error) {
        console.error("Error fetching data:", error);
        tableContainer.innerHTML = "<p>Error fetching data. Check console for details.</p>";
    }
}
