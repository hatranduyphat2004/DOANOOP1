import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FILE implements Serializable{
    //Ghi danh sách products bang list
    public void writeproduct(List<PRODUCT> list,String filename){
        File file=new File(filename);
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter(file,true);
            bw=new BufferedWriter(fw);
            for(PRODUCT a:list){
                bw.write(a.toString());
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            closeStream(bw);
            closeStream(fw);
        }
    }

    //Đọc file danh sach products bang list
    public List<PRODUCT> readproduct(String filename){
        List<PRODUCT> list=new ArrayList<>();
        File file=new File(filename);
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader(file);
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                System.out.print(line);
                System.out.println();
                if(line==null)
                   break;
                String txt[]=line.split("\\s+");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            closeStream(br);
            closeStream(fr);
        }
        return list;
    } 

    //Ghi danh sach STAFF bang list
    public void writestaff(List<STAFF> list,String filename){
        File file=new File(filename);
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter(file,true);
            bw=new BufferedWriter(fw);
            for(PERSON a:list){
                bw.write(a.toString());
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            closeStream(bw);
            closeStream(fw);
        }
    }

    //Đọc file danh sách STAFF bang list
    public List<STAFF> readstaff(String filename){
        File file=new File(filename);
        List<STAFF> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader(file);
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null)
                   break;
                String txt[]=line.split("\\s+");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            closeStream(br);
            closeStream(fr);
        }
        return list;
    }

    //Ghi danh sach khach hang bang list
    public void writecustomer(List<CUSTOMER> list,String filename){
        File file=new File(filename);
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter(file,true);
            bw=new BufferedWriter(fw);
            for(PERSON a:list){
                bw.write(a.toString());
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            closeStream(bw);
            closeStream(fw);
        }
    }

    //Đọc file danh sách khach hang bang list
    public List<CUSTOMER> readcustomer(String filename){
        File file=new File(filename);
        List<CUSTOMER> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader(file);
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null)
                   break;
                String txt[]=line.split("\\s+");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            closeStream(br);
            closeStream(fr);
        }
        return list;
    }

    //Ghi danh sach nha cung cap bang list
    public void writesupplier(List<SUPPLIER> list,String filename){
        File file=new File(filename);
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter(file,true);
            bw=new BufferedWriter(fw);
            for(PERSON a:list){
                bw.write(a.toString());
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            closeStream(bw);
            closeStream(fw);
        }
    }

    //Đọc file danh sách nha cung cap bang list
    public List<SUPPLIER> readsupplier(String filename){
        File file=new File(filename);
        List<SUPPLIER> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader(file);
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null)
                   break;
                String txt[]=line.split("\\s+");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            closeStream(br);
            closeStream(fr);
        }
        return list;
    }

    //Dong file writer/output
    public void closeStream(Writer fi){
        if(fi!=null){
            try{
                fi.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    } 

    //Dong file reader/input
    public void closeStream(Reader fi){
        if(fi!=null){
            try{
                fi.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    //Ghi chi tiet phieu nhap bang list
    public void writectphieunhap(List<CTphieunhap> list,String filename){
        File file=new File(filename);
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter(file,true);
            bw=new BufferedWriter(fw);
            for(CTphieunhap a: list){
                bw.write(a.toString());
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Doc chi tiet phieu nhap bang list
    public List<CTphieunhap> readctphieunhap(String filename){
        File file=new File(filename);
        List<CTphieunhap> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader(file);
            br=new BufferedReader(fr);
            String line=""; 
            while (true) {
                line=br.readLine();
                if(line==null)
                   break;
                String txt[]=line.split("\\s+");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            closeStream(br);
            closeStream(fr);
        }
        return list;
    }

    //Ghi danh sach chi tiet phieu xuat bang list
    public void writectphieuxuat(List<CTphieuxuat> list,String filename){
        File file=new File(filename);
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter(file,true);
            bw=new BufferedWriter(fw);
            for(CTphieuxuat a: list){
                bw.write(a.toString());
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            closeStream(bw);
            closeStream(fw);
        }
    }

    //Doc danh sach chi tiet phieu xuat bang list
    public List<CTphieuxuat> readctphieuxuat(String filename){
        File file=new File(filename);
        List<CTphieuxuat> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader(file);
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null)
                   break;
                String txt[]=line.split("\\s+");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            closeStream(br);
            closeStream(fr);
        }
        return list;
    }

    //Ghi danh sach phieu nhap bang list
    public void writephieunhap(List<PhieuNhap> list,String filename){
        File file=new File(filename);
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter(file,true);
            bw=new BufferedWriter(fw);
            for(PhieuNhap a: list){
                bw.write(a.toString());
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            closeStream(bw);
            closeStream(fw);
        }
    }

    //Doc danh sach phieu nhap bang list
    public List<PhieuNhap> readphieunhap(String filename){
        File file=new File(filename);
        List<PhieuNhap> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader(file);
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null)
                   break;
                String txt[]=line.split("\\s+");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            closeStream(br);
            closeStream(fr);
        }
        return list;
    }

    //Ghi danh sach phieu xuat bang list
     public void writephieuxuat(List<PhieuXuat> list,String filename){
        File file=new File(filename);
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter(file,true);
            bw=new BufferedWriter(fw);
            for(PhieuXuat a: list){
                bw.write(a.toString());
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            closeStream(bw);
            closeStream(fw);
        }
    }

    //Doc danh sach phieu xuat bang list
    public List<PhieuXuat> readphieuxuat(String filename){
        File file=new File(filename);
        List<PhieuXuat> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader(file);
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null)
                   break;
                String txt[]=line.split("\\s+");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            closeStream(br);
            closeStream(fr);
        }
        return list;
    }










    //Ghi danh sach san pham bang mang
    public void writefile(PRODUCT[] products,String filename){
        File file=new File(filename);
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            fos=new FileOutputStream(file,true);
            oos=new ObjectOutputStream(fos);
            for(int i=0;i<products.length;i++)
                oos.writeObject(products[i]);
            oos.close();
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Doc danh sach san pham bang mang
    public void readfile(PRODUCT[] product,String filename){
        File file=new File(filename);
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            fis =new FileInputStream(file);
            ois=new ObjectInputStream(fis);
            product=(PRODUCT[]) ois.readObject();
            ois.close();
            fis.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Ghi danh sach nhan vien bang mang
    public void writefile(STAFF[] person,String filename){
        File file=new File(filename);
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            fos=new FileOutputStream(file,true);
            oos=new ObjectOutputStream(fos);
            for(int i=0;i<person.length;i++)
                oos.writeObject(person[i]);
            oos.close();
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Doc danh sach nhan vien bang mang
    public void readfile(STAFF[] person,String filename){
        File file=new File(filename);
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            fis =new FileInputStream(file);
            ois=new ObjectInputStream(fis);
            person=(STAFF[]) ois.readObject();
            ois.close();
            fis.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Ghi danh sach nha cung cap bang mang
    public void writefile(SUPPLIER[] person,String filename){
        File file=new File(filename);
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            fos=new FileOutputStream(file,true);
            oos=new ObjectOutputStream(fos);
            for(int i=0;i<person.length;i++)
                oos.writeObject(person[i]);
            oos.close();
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Doc danh sach nha cung cap bang mang
    public void readfile(SUPPLIER[] person,String filename){
        File file=new File(filename);
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            fis =new FileInputStream(file);
            ois=new ObjectInputStream(fis);
            person=(SUPPLIER[]) ois.readObject();
            ois.close();
            fis.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //GHi danh sach khach hang bang mang
    public void writefile(CUSTOMER[] person,String filename){
        File file=new File(filename);
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            fos=new FileOutputStream(file,true);
            oos=new ObjectOutputStream(fos);
            for(int i=0;i<person.length;i++)
                oos.writeObject(person[i]);
            oos.close();
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //DOc danh sach khach hang bang mang
    public void readfile(CUSTOMER[] person,String filename){
        File file=new File(filename);
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            fis =new FileInputStream(file);
            ois=new ObjectInputStream(fis);
            person=(CUSTOMER[]) ois.readObject();
            ois.close();
            fis.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Ghi danh sach chi tiet phieu nhap bang mang
    public void writefile(CTphieunhap[] ctpn,String filename){
        File file=new File(filename);
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            fos=new FileOutputStream(file,true);
            oos=new ObjectOutputStream(fos);
            for(int i=0;i<ctpn.length;i++)
                oos.writeObject(ctpn[i]);
            oos.close();
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Doc danh sach chi tiet phieu nhap bang mang
    public void readfile(CTphieunhap[] ctpn,String filename){
        File file=new File(filename);
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            fis =new FileInputStream(file);
            ois=new ObjectInputStream(fis);
            ctpn=(CTphieunhap[]) ois.readObject();
            ois.close();
            fis.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Ghi phieu nhap bang Object
    public void writefile(PhieuNhap[] pn,String filename){
        File file=new File(filename);
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            fos=new FileOutputStream(file);
            oos=new ObjectOutputStream(fos);
            for(int i=0;i<pn.length;i++)
                oos.writeObject(pn);
            oos.close();
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Doc phieu nhap Object
    public void readfile(PhieuNhap[] pn,String filename){
        File file=new File(filename);
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            fis=new FileInputStream(file);
            ois=new ObjectInputStream(fis);
            pn=(PhieuNhap[]) ois.readObject();
            ois.close();
            fis.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Ghi phieu xuat bang Object
    public void writefile(PhieuXuat[] px,String filename){
        File file=new File(filename);
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            fos=new FileOutputStream(file);
            oos=new ObjectOutputStream(fos);
            for(int i=0;i<px.length;i++)
                oos.writeObject(px);
            oos.close();
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Doc phieu xuat bang Object
    public void readfile(PhieuXuat[] px,String filename){
        File file=new File(filename);
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            fis=new FileInputStream(file);
            ois=new ObjectInputStream(fis);
            px=(PhieuXuat[]) ois.readObject();
            ois.close();
            fis.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Ghi danh sach chi tiet phieu xuat bang mang
    public void writefile(CTphieuxuat[] ctpx,String filename){
        File file=new File(filename);
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            fos=new FileOutputStream(file,true);
            oos=new ObjectOutputStream(fos);
            for(int i=0;i<ctpx.length;i++)
                oos.writeObject(ctpx[i]);
            oos.close();
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Doc danh sach phieu xuat bang mang
    public void readfile(CTphieuxuat[] ctpx,String filename){
        File file=new File(filename);
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            fis =new FileInputStream(file);
            ois=new ObjectInputStream(fis);
            ctpx=(CTphieuxuat[]) ois.readObject();
            ois.close();
            fis.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // Kiem tra file co rong khong
    public void checkFile(String tenFile) {
        File file = new File(tenFile);
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    System.out.println("File khong trong.");
                    return;
                }
            }
            System.out.println("Tep trong.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        FILE a=new FILE();
        a.checkFile(null);
    }
}
