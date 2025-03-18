package com.example.kotlin.model

class Contact {
    //package là namespace //bao vệ quyền truy cập //Khi nào dùng string/number cho phone? number chỉ dùng để tính toán
    private val id: Int
    private var name: String
    private var phone: String

    constructor(id: Int, name: String, phone: String) {
        this.id = id
        this.name = name
        this.phone = phone
    }
}