export class Blog {
    id : string;
}

export class User {
    id: string;
    email: string;
    fullName: string | undefined;
    password: string;

    constructor(email: string, password: string, fullName?: string) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }
}