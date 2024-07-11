document.addEventListener('DOMContentLoaded', function() {
    const menuOpen = document.querySelector('#menu-open');
    const menuClose = document.querySelector('#menu-close');
    const menuPanel = document.querySelector('#menu-panel');

    const menuOptions = {
        duration: 1400,
        easing: 'ease',
        fill: 'forwards',
    };

    menuOpen.addEventListener('click', () => {
        menuPanel.animate({ transform: ['translateX(100vw)', 'translateX(0)'] }, menuOptions);
    });

    menuClose.addEventListener('click', () => {
        menuPanel.animate({ transform: ['translateX(0)', 'translateX(100vw)'] }, menuOptions);
    });
});
