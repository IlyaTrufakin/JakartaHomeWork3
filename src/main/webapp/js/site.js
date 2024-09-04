console.log("Script works");


function addToTerminal(message) {
    const terminalContent = document.getElementById('terminal-content');
    const messageElement = document.createElement('div');
    messageElement.textContent = new Date().toLocaleTimeString() + ': ' + message;
    terminalContent.appendChild(messageElement);
    terminalContent.scrollTop = terminalContent.scrollHeight;
}

// Функция для обновления отладочной информации
function updateDebugInfo() {
    addToTerminal('Fetching debug info...');
    fetch('<%=contextPath%>/api/debug-info')
        .then(response => response.json())
        .then(data => {
            addToTerminal('Debug info received:');
            for (let key in data) {
                addToTerminal(`${key}: ${data[key]}`);
            }
        })
        .catch(error => {
            addToTerminal('Error fetching debug info: ' + error);
        });
}

// Добавляем начальную отладочную информацию
var debugMessages =  debugMessagesJson;
debugMessages.forEach(function(message) {
    addToTerminal(message);
});

// Добавляем обработчик события для кнопки обновления
document.getElementById('update-debug-info').addEventListener('click', updateDebugInfo);

// Опционально: можно вызвать updateDebugInfo() сразу после загрузки страницы
// updateDebugInfo();

// Опционально: можно настроить периодическое обновление
 setInterval(updateDebugInfo, 1000); // Обновление каждую минуту