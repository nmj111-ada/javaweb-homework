document.addEventListener('DOMContentLoaded', function() {
    const themeSelect = document.getElementById('themeSelect');
    const body = document.body;

    // 检查本地存储
    const savedTheme = localStorage.getItem('selectedTheme');
    if (savedTheme) {
        body.className = savedTheme + '-theme';
        themeSelect.value = savedTheme;
    } else {
        body.className = 'light-theme';
    }

    themeSelect.addEventListener('change', function() {
        const selected = this.value;
        body.className = selected + '-theme';
        localStorage.setItem('selectedTheme', selected);
    });
});