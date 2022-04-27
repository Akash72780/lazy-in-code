var app = angular.module("myApp", ["ngRoute"]);

app.run(function ($rootScope) {
  $rootScope.userName = undefined;
});

app.config([
  "$routeProvider",
  "$locationProvider",
  function ($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);
    $routeProvider
      .when("/", {
        templateUrl: "html/index-home.html",
        controller: "indexController",
      })
      .when("/book", {
        templateUrl: "html/book.html",
        controller: "bookController",
      })
      .when("/apparel", {
        templateUrl: "html/apparel.html",
        controller: "apparelController",
      })
      .when("/search", {
        templateUrl: "html/search.html",
        controller: "searchController",
      })
      .when("/cart", {
        templateUrl: "html/cart.html",
        controller: "cartController",
      })
      .when("/viewBookCart", {
        templateUrl: "html/viewBookCart.html",
        controller: "viewBookCartController",
      })
      .when("/viewApparelCart", {
        templateUrl: "html/viewApparelCart.html",
        controller: "viewApparelCartController",
      })
      .otherwise({ redirectTo: "/" });
  },
]);
//index page
app.controller("indexController", function ($scope, $location) {});
//search
app.controller("searchController", function ($scope, $location, $http) {
  let searchValue = $scope.searchValue;
  var url = "";
  if (angular.lowercase(searchValue) == "book") {
    $location.path("/book");
  } else if (angular.lowercase(searchValue) == "apparel") {
    $location.path("/apparel");
  } else {
    if (searchValue.length == 4) {
      if (searchValue.startsWith("P1")) {
        url = "http://localhost:8080/api/v1/product/id/" + searchValue;
      }
    } else {
      url = "http://localhost:8080/api/v1/product/name/" + searchValue;
    }
    $http.get(url).then(
      function mySuccess(response) {
        console.log(response.data);
        var result = response.data;
        result.forEach((product) => {
          if (product.itemId.startsWith("B")) {
            product.type = "Book";
          } else {
            product.type = "Apparel";
          }
        });
        $scope.listofSearch = result;
      },
      function myError(response) {
        console.log("response");
        $location.path('/');
      }
    );
  }

  $scope.addToCart = function (product) {
    var addUrl = "http://localhost:8080/api/v2/cart/add";
    $http.post(addUrl, product).then(
      function mySuccess(response) {
        console.log("added data is " + response.data);
      },
      function myError(response) {
        $location.path('/');
      }
    );
  };
});

//Book page
app.controller(
  "bookController",
  function ($scope, $http, $location) {
    var url = "http://localhost:8080/api/v1/book";
    console.log(url);
    $http.get(url).then(
      function mySuccess(response) {
        console.log(response.data);
        $scope.listofBook = response.data;
      },
      function myError(response) {
        $location.path('/');
      }
    );

    $scope.addToCart = function (book) {
      var addUrl = "http://localhost:8080/api/v2/cart/add";
      $http.post(addUrl, book).then(
        function mySuccess(response) {
          console.log("added data is " + response.data);
        },
        function myError(response) {
          // this function handles error
        }
      );
    };
  }
);

//Apparel page
app.controller(
  "apparelController",
  function ($scope, $http, $location) {
    var url = "http://localhost:8080/api/v1/apparel";
    console.log(url);
    $http.get(url).then(
      function mySuccess(response) {
        console.log(response.data);
        $scope.listofApparel = response.data;
      },
      function myError(response) {
        $location.path('/');
      }
    );

    $scope.addToCart = function (apparel) {
      var addUrl = "http://localhost:8080/api/v2/cart/add";
      $http.post(addUrl, apparel).then(
        function mySuccess(response) {
          console.log("added data is " + response.data);
          // $route.reload();
        },
        function myError(response) {
          $location.path('/');
        }
      );
    };
  }
);

//cart page
app.controller("cartController", function ($scope, $route, $http, $location) {
  var url = "http://localhost:8080/api/v2/cart";
  $http.get(url).then(
    function mySuccess(response) {
      var listofProd = response.data;
      $scope.listofProd = listofProd;
      var totalPrice = 0;
      listofProd.forEach((product) => {
        totalPrice = totalPrice + product.count * product.price;
      });
      $scope.totalPrice = totalPrice;
    },
    function myError(response) {
      $location.path('/');
    }
  );

  $scope.viewProduct = function (product) {
    localStorage.setItem("cart", JSON.stringify(product));
    if (product.type == "Book") {
      $location.path("/viewBookCart");
    } else {
      $location.path("/viewApparelCart");
    }
  };

  $scope.updateProduct = function (product) {
    localStorage.setItem("cart", JSON.stringify(product));
    if (product.type == "Book") {
      $location.path("/viewBookCart");
    } else {
      $location.path("/viewApparelCart");
    }
  };

  $scope.deleteProduct = function (product) {
    var deleteUrl = "http://localhost:8080/api/v2/cart/delete";
    $http.post(deleteUrl, product).then(
      function mySuccess(response) {
        $route.reload();
      },
      function myError(response) {
        $location.path('/');
      }
    );
  };
  $scope.handleAllRemoveAction=function(){
    var removeUrl = "http://localhost:8080/api/v2/cart";
    $http.delete(removeUrl).then(
      function mySuccess(response) {
        $route.reload();
      },
      function myError(response) {
        $location.path('/');
      }
    );
  };
});
//view or update book in cart
app.controller("viewBookCartController", function ($scope, $http, $location) {
  var cart = JSON.parse(localStorage.getItem("cart"));

  var url = "http://localhost:8080/api/v2/cart/view/book";
  $http.post(url, cart).then(
    function mySuccess(response) {
      console.log("added data is " + response.data);
      var product = response.data;
      $scope.prodId = product.prodId;
      $scope.prodName = product.prodName;
      $scope.price = product.price;
      $scope.count = product.count;
      $scope.genre = product.genre;
      $scope.author = product.author;
      $scope.publication = product.publication;
    },
    function myError(response) {
      $location.path('/');
    }
  );
  $scope.handleUpdateAction = function () {
    var url = "http://localhost:8080/api/v2/cart/update";
    var cart = JSON.parse(localStorage.getItem("cart"));
    cart.count = $scope.count;

    $http.post(url, cart).then(
      function mySuccess(product) {
        console.log("added data is " + product.data);
        $location.path("/cart");
      },
      function myError(response) {
        $location.path('/');
      }
    );
  };
  $scope.handleBackAction = function () {
    $location.path("/cart");
  };
});

//view or update apparel in cart
app.controller(
  "viewApparelCartController",
  function ($scope, $http, $location) {
    var cart = JSON.parse(localStorage.getItem("cart"));

    var url = "http://localhost:8080/api/v2/cart/view/apparel";
    $http.post(url, cart).then(
      function mySuccess(response) {
        console.log("added data is " + response.data);
        var product = response.data;
        $scope.prodId = product.prodId;
        $scope.prodName = product.prodName;
        $scope.price = product.price;
        $scope.count = product.count;
        $scope.genre = product.type;
        $scope.author = product.brand;
        $scope.publication = product.design;
      },
      function myError(response) {
        $location.path('/');
      }
    );
    $scope.handleUpdateAction = function () {
      var url = "http://localhost:8080/api/v2/cart/update";
      var cart = JSON.parse(localStorage.getItem("cart"));
      cart.count = $scope.count;

      $http.post(url, cart).then(
        function mySuccess(product) {
          console.log("added data is " + product.data);
          $location.path("/cart");
        },
        function myError(response) {
          $location.path('/');
        }
      );
    };
    $scope.handleBackAction = function () {
      $location.path("/cart");
    };
  }
);
