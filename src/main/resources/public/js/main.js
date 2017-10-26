var app = angular.module("app", []);

app.controller("ctrlProduct", function ($scope, $http, $window, $sce) {

    // //-------updateProduct-----------------------------------------
    //
    // $scope.getUpdateProductById = function (index) {
    //  $http({
    //      method:'GET',
    //      url:'/productRest/getProductById/',
    //      params:{index:index}
    //  }).then(function (resp) {
    //      $scope.updateProduct = resp.data;
    //  }, function (resp) {
    //
    //  })
    // };
    //
    //
    // //-------------------------------------------------------------
    //
    //
    //
    // //-----------------DetalProduct--------------------------------
    //
    // $scope.hello = 'hello world';
    // $scope.getDetalisProduct = function (index) {
    //     $http({
    //             method: "GET",
    //             url: "/productRest/getProductById/",
    //             params: {index: index}
    //         }
    //     ).then(function (response) {
    //         $scope.detalProduct = response.data;
    //         console.log($scope.detalProduct)
    //     }, function (response) {
    //
    //     });
    // };
    //
    // //-------------------------------------------------------------
    // //------------All Product--------------------------
    //
    // function getAllProduct() {
    //     $http({
    //             method: "GET",
    //             url: "/productRest/getAllProduct/"
    //         }
    //     ).then(function (response) {
    //         $scope.allProducts = response.data;
    //         console.log(response.data);
    //     }, function (response) {
    //
    //     });
    // }
    //
    // getAllProduct();
    //
    // //-------------------------------------------------
    //
    // //---------------product---------------------------
    //
    //
    // var updateProductVar = function () {
    //     $scope.errorValidTitleProduct = false;
    //     $scope.errorNonTitleProduct = false;
    //     $scope.purchasePrice = "";
    //     $scope.percentageMarkup = "";
    //     $scope.titleProduct = '';
    //     $scope.errorNonTitleProductInput = '';
    //     $scope.brendSelect = '';
    //     $scope.brendSelected = [];
    //     $scope.errorNonBrendProduct = false;
    //     $scope.errorNonBrendProductInput = '';
    //     $scope.categorySelect = '';
    //     $scope.errorNonCetegoryProduct = false;
    //     $scope.errorNonCetegoryProductInput = '';
    //     $scope.notationProduct = "";
    // };
    //
    // updateProductVar();
    //
    // $scope.showSelectedBrendValue = function (brend) {
    //     $scope.errorNonBrendProduct = false;
    //     $scope.errorNonBrendProductInput = '';
    //     if ($scope.brendSelected.indexOf(brend) === -1){
    //         $scope.brendSelected.push(brend);
    //         console.log($scope.brendSelected);
    //     }
    // };
    // $scope.showSelectedCategoryValue = function (category) {
    //     $scope.errorNonCetegoryProduct = false;
    //     $scope.errorNonCetegoryProductInput = '';
    // };
    //
    // $scope.deleteBrandSelected = function (index) {
    //     $scope.brendSelected.splice(index, 1);
    // };
    //
    //
    // $scope.addNewProductBtn = function () {
    //
    //     console.log($scope.brendSelected.length);
    //     if ($scope.titleProduct === '') {
    //         $scope.errorNonTitleProduct = true;
    //         $scope.errorNonTitleProductInput = "errorInput"
    //     }
    //     if ($scope.brendSelected.length === 0) {
    //         $scope.errorNonBrendProduct = true;
    //         $scope.errorNonBrendProductInput = "errorInput"
    //     }
    //     if ($scope.categorySelect === '') {
    //         $scope.errorNonCetegoryProduct = true;
    //         $scope.errorNonCetegoryProductInput = 'errorInput';
    //     }
    //
    //     if ($scope.categorySelect !== '' && $scope.brendSelected !== 0 && $scope.titleProduct !== '') {
    //         $http({
    //                 method: "GET",
    //                 url: "/productRest/addNewProduct/",
    //                 params: {
    //                     titleProduct: $scope.titleProduct,
    //                     brendProducts: $scope.brendSelected,
    //                     categoryProduct: $scope.categorySelect,
    //                     purchasePriceProduct: $scope.purchasePrice,
    //                     percentageMarkupProduct: $scope.percentageMarkup,
    //                     notationProduct: $scope.notationProduct
    //                 }
    //             }
    //         ).then(function (response) {
    //             updateProductVar();
    //             $('#modalNewProductBtn').modal('hide');
    //             $window.location.href = "/product"
    //         }, function (response) {
    //             if (response.status === 417) {
    //                 $scope.errorValidTitleProduct = true;
    //                 $scope.errorNonTitleProductInput = "errorInput"
    //             }
    //         })
    //     }
    //
    // };
    //
    // $scope.keydownInputTextTitleProduct = function () {
    //     $scope.errorNonTitleProduct = false;
    //     $scope.errorNonTitleProductInput = '';
    //     $scope.errorValidTitleProduct = false;
    // };
    //
    // $scope.showModalAddNewProduct = false;
    //
    // $scope.newDataProductBtn = function () {
    //     $http({
    //             method: "GET",
    //             url: "/productRest/getAllTitleBrand/"
    //         }
    //     ).then(function (response) {
    //         $scope.allTitleBrand = response.data.allTitleBrand;
    //         $scope.allTitleCategory = response.data.allTitleCategory;
    //         $scope.showModalAddNewProduct = true;
    //     }, function (response) {
    //         $('#modalNewProductBtn').modal('hide');
    //     })
    // };
    //
    // //-------------------------------------------------
    //
    // updateError();
    //
    // getAllBrands();
    //
    // function getAllBrands() {
    //     $http({
    //             method: "GET",
    //             url: "/productRest/getAllBrands/"
    //         }
    //     ).then(function (response) {
    //         $scope.allBrands = response.data;
    //     }, function (response) {
    //
    //     })
    // }
    //
    // function updateError() {
    //     $scope.errorNonTitleBrand = false;
    //     $scope.errorValidTitleBrand = false;
    //     $scope.errorNonInputBrand = "";
    // }
    //
    // $scope.brand = {
    //     title: "",
    //     notation: ""
    // };
    //
    // $scope.hideInputText = function () {
    //     updateError();
    // };
    //
    // $scope.addNewBrandBtn = function () {
    //
    //     if ($scope.brand.title === "") {
    //         $scope.errorNonInputBrand = "errorInput";
    //         $scope.errorNonTitleBrand = true;
    //     } else {
    //         $http({
    //             method: "POST",
    //             url: "/productRest/newBrand/",
    //             data: $scope.brand
    //
    //         }).then(function (response) {
    //             if (response.status === 201) {
    //                 $scope.brand = {
    //                     title: "",
    //                     notation: ""
    //                 };
    //                 updateError();
    //                 $('#modalNewBrandBtn').modal('hide');
    //                 $window.location.href = "/product"
    //             } else {
    //
    //
    //                 $('#modalNewBrandBtn').modal('hide');
    //             }
    //         }, function (response) {
    //             if (response.status === 501) {
    //                 $scope.errorNonInputBrand = "errorInput";
    //                 $scope.errorValidTitleBrand = true;
    //             }
    //
    //         });
    //
    //
    //         console.log($scope.category.title);
    //     }
    //
    //
    // };


    //-----category-------------

    $scope.getDetalisProduct = function (index) {
        for (var i = 0; i < $scope.allProducts.length; i++){
            if ($scope.allProducts[i].id === index){
                $scope.detalProduct = $scope.allProducts[i];
                console.log($scope.detalProduct);
            }
        }
    };

    $scope.sce = $sce;


    $scope.getCategoryById = function (id) {
        $http({
            url:"/productRest/getProductsById/",
            method:"GET",
            params: {id: id}
        }).then(function (resp) {
            $scope.allProducts = resp.data;
            console.log(resp.data);
        }, function (resp) {

        })
    };

    getAllCategory();

    function getAllCategory() {
        $http({
                method: "GET",
                url: "/productRest/getAllCategory/"
            }
        ).then(function (response) {
            $scope.allCategory = response.data;
            console.log(response.data);
        }, function (response) {

        })
    }

    $scope.category = {
        title: ""
    };

    $scope.errorNonInput = "";
    $scope.errorNonText = false;
    $scope.errorValidTextCategory = false;

    $scope.addNewCategoryBtn = function () {

        if ($scope.category.title === "") {
            $scope.errorNonInput = "errorInput";
            $scope.errorNonText = true;
        } else {

            $http({
                method: "POST",
                url: "/productRest/newCategory/",
                data: $scope.category

            }).then(successNewCategory, errorNewCategory);


            console.log($scope.category.title);
        }


    };

    $scope.keydownInputText = function () {
        $scope.errorNonInput = "";
        $scope.errorNonText = false;
        $scope.errorValidTextCategory = false;
    };

    function successNewCategory(response) {

        if (response.status === 201) {
            $scope.category = {
                title: ""
            };
            $('#modalNewCategoryBtn').modal('hide');
            $window.location.href = "/product"
        } else {

        }

    }

    function errorNewCategory() {
        $scope.errorNonInput = "errorInput";
        $scope.errorValidTextCategory = true;
    }

    //-----category end-------------

});

//end controller Category

app.controller("ctrlAllClient", function ($scope, $http) {


    $scope.btnAddNewClient = function (clientId) {

        var getUserPrimes = $http({
            method: "GET",
            url: "/client/getDetalisClient/" + clientId
        });

        getUserPrimes.then(successDetalisClient, errorDetalisClient);
    };

    function successDetalisClient(response) {
        $scope.clientDetal = response.data;
    }

    function errorDetalisClient(response) {

    }


    function getAllClient() {

        function successAllClient(response) {
            $scope.clients = response.data;
        }

        function errorAllClient(response) {

        }

        var promiseAllClient = $http({
            method: "GET",
            url: "/client/getAll/"
        });

        promiseAllClient.then(successAllClient, errorAllClient);

    }

    getAllClient();
});

app.controller("ctrlNewClient", function ($scope, $http, $window) {

    var updateClient = function () {
        return {
            name: '',
            titleCompany: '',
            phone: '',
            email: '',
            skype: '',
            notation: ''
        };
    };

    var updateError = function () {
        $scope.errorInputValidName = "";
        $scope.errorInputValidPhone = "";
        $scope.errorName = false;
        $scope.errorPhone = false;
    };
    $scope.client = updateClient();


    function successAddClient(response) {
        if (response.status > 200) {
            $scope.client = updateClient();
            console.log(response.status);
            updateError();
            $window.location.href = "/"
        }

        $('#modalNewClient').modal('hide');
    }

    function errorAddClient(response) {
        if (response.status === 417) {
            console.log(response.data);
            if (response.data.name === "error") {
                $scope.errorInputValidName = "errorInput";
                $scope.errorName = true;
            }
            if (response.data.phone === "error") {
                $scope.errorInputValidPhone = "errorInput";
                $scope.errorPhone = true;
            }

        }

    }

    $scope.btnAddNewClient = function (client) {

        var promise = $http({
            method: "POST",
            url: "/client/newClient/",
            data: client
        });

        promise.then(successAddClient, errorAddClient);
    };

    $scope.focusErrorName = function () {
        $scope.errorName = false;
        $scope.errorInputValidName = "";
    };

    $scope.focusErrorPhone = function () {
        $scope.errorPhone = false;
        $scope.errorInputValidPhone = "";
    };
});
