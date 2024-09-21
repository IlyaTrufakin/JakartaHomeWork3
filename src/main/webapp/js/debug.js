let lastLogUpdateTime = 0;
let isUpdatingLogs = false;

document.addEventListener('DOMContentLoaded', function() {
    initializeDebugObserver();
    fetchDebugLogs(); // Запрашиваем логи сразу при загрузке
});



function initializeDebugObserver() {
    const observer = new PerformanceObserver((list) => {
        console.log('PerformanceObserver triggered');
        list.getEntries().forEach((entry) => {
            console.log('Observed entry:', entry.name);
            if (entry.name.startsWith(window.location.origin) && !entry.name.includes('/api/debug-info')) {
                console.log('Triggering log update check for:', entry.name);
                checkForLogUpdates(entry.name);
            }
        });
    });
    observer.observe({ entryTypes: ['resource', 'navigation'] }); // Добавлено 'navigation'
}


//
// function initializeDebugObserver() {
//     const observer = new PerformanceObserver((list) => {
//         console.log('PerformanceObserver triggered');
//         list.getEntries().forEach((entry) => {
//             console.log('Observed entry:', entry.name);
//             if (entry.name.startsWith(window.location.origin) && !entry.name.includes('/api/debug-info')) {
//                 checkForLogUpdates(entry.name);
//             }
//         });
//     });
//     observer.observe({entryTypes: ['resource']});
// }

function checkForLogUpdates(url) {
    console.log('checkForLogUpdates triggered for:', url);
    fetch(url, { method: 'HEAD' })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok: ' + response.statusText);
            }
            return onServerResponse(response);
        })
        .catch(error => console.error('Error checking headers:', error.message));
}

//
// function checkForLogUpdates(url) {
//     console.log('checkForLogUpdates triggered');
//     fetch(url, { method: 'HEAD' })
//         .then(response => onServerResponse(response))
//         .catch(error => console.error('Error checking headers:', error));
// }

function onServerResponse(response) {
    console.log('Server response headers:', response.headers);
    const serverLogUpdateTime = parseInt(response.headers.get('X-Log-Update-Time') || '0');
    console.log('Server log update time:', serverLogUpdateTime);

    if (isUpdatingLogs) {
        // Игнорируем ответ от API запроса обновления логов
        return;
    }

    if (serverLogUpdateTime > lastLogUpdateTime) {
        fetchDebugLogs();
    }
}

function fetchDebugLogs() {
    if (isUpdatingLogs) {
        return; // Предотвращаем параллельные запросы
    }

    isUpdatingLogs = true;
    fetch(contextPath + '/api/debug-info')
        .then(response => {
            const newUpdateTime = parseInt(response.headers.get('X-Log-Update-Time') || '0');
            lastLogUpdateTime = Math.max(lastLogUpdateTime, newUpdateTime);
            return response.json();
        })
        .then(messages => {
            messages.forEach(addToTerminal);
        })
        .catch(error => console.error('Error fetching debug logs:', error))
        .finally(() => {
            isUpdatingLogs = false;
        });
}

function addToTerminal(message) {
    const terminalContent = document.getElementById('terminal-content');
    const messageElement = document.createElement('div');
    messageElement.innerHTML = new Date().toLocaleTimeString() + ': ' + message.replace(/\n/g, '<br>');
    terminalContent.appendChild(messageElement);
    terminalContent.scrollTop = terminalContent.scrollHeight;
}






//
// let lastLogUpdateTime = 0;
// let isUpdatingLogs = false;
//
// document.addEventListener('DOMContentLoaded', function() {
//     // Инициализация PerformanceObserver и другого кода
//     initializeDebugObserver();
// });
//
// function initializeDebugObserver() {
//     const observer = new PerformanceObserver((list) => {
//         list.getEntries().forEach((entry) => {
//             if (entry.name.startsWith(window.location.origin) && !entry.name.includes('/api/debug-log')) {
//                 checkForLogUpdates(entry.name);
//             }
//         });
//     });
//     observer.observe({entryTypes: ['resource']});
// }

//
// function onServerResponse(response) {
//     console.log('Server response headers:', response.headers);
//     const serverLogUpdateTime = parseInt(response.headers.get('X-Log-Update-Time') || '0');
//     console.log('Server log update time:', serverLogUpdateTime);
//
//     if (isUpdatingLogs) {
//         // Игнорируем ответ от API запроса обновления логов
//         return;
//     }
//
//     const serverLogUpdateTime = parseInt(response.headers.get('X-Log-Update-Time') || '0');
//
//     if (serverLogUpdateTime > lastLogUpdateTime) {
//         fetchDebugLogs();
//     }
// }


//
// function fetchDebugLogs() {
//     if (isUpdatingLogs) {
//         return; // Предотвращаем параллельные запросы
//     }
//
//     isUpdatingLogs = true;
//     fetch(contextPath + '/api/debug-info')
//         .then(response => {
//             const newUpdateTime = parseInt(response.headers.get('X-Log-Update-Time') || '0');
//             lastLogUpdateTime = Math.max(lastLogUpdateTime, newUpdateTime);
//             return response.json();
//         })
//         .then(messages => {
//             messages.forEach(addToTerminal);
//         })
//         .catch(error => console.error('Error fetching debug logs:', error))
//         .finally(() => {
//             isUpdatingLogs = false;
//         });
// }

//
// document.addEventListener('DOMContentLoaded', function() {
//     initializeDebugObserver();
//     fetchDebugLogs(); // Запрашиваем логи сразу при загрузке
// });
//


//
// let originalFetch = window.fetch;
//
// window.fetch = function () {
//     return originalFetch.apply(this, arguments).then(response => {
//         updateDebugInfo();
//         return response;
//     });
// };
//
//
// let updateDebugInfoTimer;
//
// function updateDebugInfo() {
//     console.log("updateDebugInfo works");
//     clearTimeout(updateDebugInfoTimer);
//     updateDebugInfoTimer = setTimeout(() => {
//         fetch(contextPath + '/api/debug-info')
//             .then(response => response.json())
//             .then(data => {
//                 data.forEach(message => addToTerminal(message));
//             })
//             .catch(error => console.error('Error updating debug info:', error));
//     }, 5000); // Задержка в 5 секунд
// }

// Использование с PerformanceObserver
// const observer = new PerformanceObserver((list) => {
//     console.log('PerformanceObserver triggered');
//     list.getEntries().forEach((entry) => {
//         console.log('Observed entry:', entry.name);
//         if (entry.name.startsWith(window.location.origin) && !entry.name.includes('/api/debug-log')) {
//             fetch(entry.name, { method: 'HEAD' })
//                 .then(response => onServerResponse(response))
//                 .catch(error => console.error('Error checking headers:', error));
//         }
//     });
// });
//
// observer.observe({entryTypes: ['resource']});
//
//
//
// function addToTerminal(message) {
//     const terminalContent = document.getElementById('terminal-content');
//     const messageElement = document.createElement('div');
//     messageElement.innerHTML = new Date().toLocaleTimeString() + ': ' + message.replace(/\n/g, '<br>');
//     terminalContent.appendChild(messageElement);
//     terminalContent.scrollTop = terminalContent.scrollHeight;
// }
//

//document.addEventListener('DOMContentLoaded', updateDebugInfo);
// Вызываем проверку после загрузки страницы
//document.addEventListener('DOMContentLoaded', checkForNewLogs);