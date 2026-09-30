class MinStack {
    private values: number[];
    private mins: number[];

    constructor() {
        this.values = [];
        this.mins = [];
    }

    /**
     * @param {number} val
     * @return {void}
     */
    push(val: number): void {
        this.values.push(val);

        const prevMin = this.mins.length === 0 ? val : this.mins[this.mins.length-1];

        this.mins.push(Math.min(val,prevMin));

    }

    /**
     * @return {void}
     */
    pop(): void {
        this.values.pop();
        this.mins.pop();
    }

    /**
     * @return {number}
     */
    top(): number {
        return this.values[this.values.length-1];
    }

    /**
     * @return {number}
     */
    getMin(): number {
        return this.mins[this.mins.length-1];
    }
}
