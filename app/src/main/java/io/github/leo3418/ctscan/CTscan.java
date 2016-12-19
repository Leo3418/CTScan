package io.github.leo3418.ctscan;

class CTscan{
    private int[] voxel;

    void setVoxel(int[] input){
        voxel = input;
    }

    int[] getHorizontal(){
        int[] output = new int[4];
        output[0] = voxel[0] + voxel[1];
        output[1] = voxel[0] + voxel[1];
        output[2] = voxel[2] + voxel[3];
        output[3] = voxel[2] + voxel[3];
        return output;
    }

    int[] getTopleft_Bottomright(){
        int[] output = new int[4];
        output[0] = voxel[0] + voxel[3];
        output[1] = voxel[1];
        output[2] = voxel[2];
        output[3] = voxel[0] + voxel[3];
        return output;
    }

    int[] getVertical(){
        int[] output = new int[4];
        output[0] = voxel[0] + voxel[2];
        output[1] = voxel[1] + voxel[3];
        output[2] = voxel[0] + voxel[2];
        output[3] = voxel[1] + voxel[3];
        return output;
    }

    int[] getTopright_Bottomleft(){
        int[] output = new int[4];
        output[0] = voxel[0];
        output[1] = voxel[1] + voxel[2];
        output[2] = voxel[1] + voxel[2];
        output[3] = voxel[3];
        return output;
    }

    int[] getOverall(){
        int[] output = new int[4];
        for(int i = 0; i < 4; i++) output[i] = getHorizontal()[i] + getTopleft_Bottomright()[i] + getVertical()[i] + getTopright_Bottomleft()[i];
        return output;
    }

    int[] getBackground(){
        int[] output = new int[4];
        int background = getOverall()[0] - 3 * voxel[0];
        for(int i = 0; i < 4; i++) output[i] = background;
        return output;
    }

    int[] getResult(){
        int[] output = new int[4];
        for(int i = 0; i < 4; i++) output[i] = (getOverall()[i] - getBackground()[i]) / 3;
        return output;
    }
}
