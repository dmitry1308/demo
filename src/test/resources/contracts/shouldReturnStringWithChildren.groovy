package contracts

import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "should return string"
    request{
        method GET()
        url("/validate/passportString") {
            queryParameters {
                parameter("path", "data/DataDmitry.json")
            }
        }
    }
    response {
        body("Passport{series=5006, number=1111, childrenList=[Children{name='Eva', age=5}, Children{name='Petr', age=8}]}")
        status 200
    }
}