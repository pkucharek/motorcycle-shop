window.onload = () => {
    cylinders = document.getElementById('cylinders');
    if (cylinders.value === '0') {
        cylinders.value = '';
    }
    engineCapacity = document.getElementById('engineCapacity');
    if (engineCapacity.value === '0') {
        engineCapacity.value = '';
    }
}
