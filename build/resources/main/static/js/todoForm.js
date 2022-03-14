const todoController = new TodoController();


form.addEventListener('submit', (event) => {
    event.preventDefault();

    const newTodoTitle = document.querySelector('#title');
    const newTodoDescription = document.querySelector('#desc');
    const newTodoDate = document.querySelector('#date');

    const title = newTodoTitle.value;
    const description = newTodoDescription.value;
    const date = newTodoDate.value;

    newTodoTitle.value = '';
    newTodoDescription.value = '';
    newTodoDate.value = '';

    todoController.addTodoList(title, description, date);


})