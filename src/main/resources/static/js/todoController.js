
class TodoController {

    constructor() {
    // create empty array to store the details of todoList
    this.todoList = [];
    }

    // method to add todos into the array
    addTodoList(title, description, date) {

        let todoController = this;
        const formData = new FormData();
        formData.append('title', title);
        formData.append('description', description);
        formData.append('date', date);


        fetch('http://127.0.0.1:8080/add', {
            method: 'POST',
            body: formData})
            .then(function(response) {
                console.log(response.status);
                if (response.ok) {
                    alert("Successfully Added Todo List!")
                }
            })
            .catch((error) => {
                console.log('Error:', error);
                alert("Error adding Todo List!")
            });

    }



    displayTodoList() {

        let todoController = this;

        todoController.todoList = [];

        fetch('http://127.0.0.1:8080/all')
            .then((response) => response.json())
            .then(function(data) {
                console.log("Receiving data");
                console.log(data);
                data.forEach(function (todo) {

                    const todoObj = {
                        id: todo.id,
                        title: todo.title,
                        description: todo.description,
                        date: todo.date
                    };
                    todoController.todoList.push(todoObj);
                });

                todoController.renderTodoList();
            })
            .catch(function(error) {
                console.log(error);
            });

    }


    renderTodoList() {

        let todoHtmlList = [];

        for (let i = 0; i < this.todoList.length; i++) {
            const todo = this.todoList[i];

            const todoHtml = `
                <tr>
                    <td>${todo.title}</td>
                    <td>${todo.description}</td>
                    <td>${todo.date}</td>
                </tr>
            `;

            todoHtmlList.push(todoHtml);
        }

        document.querySelector("#tbody").innerHTML = todoHtmlList.join('\n');

    }

}