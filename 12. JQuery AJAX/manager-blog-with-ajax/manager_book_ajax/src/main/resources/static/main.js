function search() {
    var search = document.getElementById("search").value;
    $.ajax({
        type: "GET",
        url: "/blog?search=" + search,
        dataType: "HTML",
        success: function (data) {
            $("#main").html(data);
        }
    });
}
function loadMore() {
    var count = document.getElementsByClassName("count").length;

    $.ajax({
        type: "GET",
        url: "/api/blog/load",
        data: {
            exits: count
        },
        success: function (data) {
            var row = document.getElementById("row");
            for (var i = 0; i < data.length; i++) {
                var result = 
                `<tr>
                    <td class="count">${data[i].id}</td>
                    <td>${data[i].type}</td>
                    <td>${data[i].author}</td>
                    <td>${data[i].category.getName()}</td>
                </tr>`;
            }
            row.innerHTML += result;
        }
    });
}