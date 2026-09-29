class TimeMap {
    private keyStore:Map<string, {timestamp:number; value:string}[]>

    constructor() {
        this.keyStore = new Map();
    }

    /**
     * @param {string} key
     * @param {string} value
     * @param {number} timestamp
     * @return {void}
     */
    set(key: string, value: string, timestamp: number): void {
        if (!this.keyStore.has(key)) {
            this.keyStore.set(key, []);
        }

        this.keyStore.get(key)!.push({timestamp, value});
    }

    /**
     * @param {string} key
     * @param {number} timestamp
     * @return {string}
     */
    get(key: string, timestamp: number): string {
        const entries = this.keyStore.get(key);
        if (entries === undefined) return "";

        let left = 0;
        let right = entries.length - 1;
        let result = "";

        while (left <= right) {
            const mid = Math.floor((left+right)/2);

            if (entries[mid].timestamp <= timestamp) {
                result = entries[mid].value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
